-- 每个用户连续登录的最大窗口长度
-- 连续定义：按 login_date 排序后，相邻两次登录间隔 <= 2 天
WITH login_dedup AS (
    SELECT DISTINCT
        user_id
        , login_date
    FROM
        user_login
)
, login_ordered AS (
    SELECT
        user_id
        , login_date
        , LAG(login_date) OVER (PARTITION BY user_id ORDER BY login_date) AS prev_login_date
    FROM
        login_dedup
)
, login_grouped AS (
    SELECT
        user_id
        , login_date
        -- 间隔 > 2 天则开启新窗口，累计得到窗口编号
        , SUM(
            CASE
                WHEN prev_login_date IS NULL
                    OR DATEDIFF(login_date, prev_login_date) > 2
                THEN 1
                ELSE 0
            END
        ) OVER (PARTITION BY user_id ORDER BY login_date) AS window_id
    FROM
        login_ordered
)
, window_len AS (
    SELECT
        user_id
        , window_id
        , COUNT(*) AS streak_len
    FROM
        login_grouped
    GROUP BY
        user_id
        , window_id
)
SELECT
    user_id
    , MAX(streak_len) AS max_consecutive_logins
FROM
    window_len
GROUP BY
    user_id;
