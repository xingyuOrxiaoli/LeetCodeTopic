
SELECT
    A.player_id,
    MIN(A.event_date) AS first_login
FROM
    a511_游戏玩法分析i_activity A
GROUP BY
    A.player_id;