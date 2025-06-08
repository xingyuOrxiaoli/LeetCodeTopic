
create table a178_分数排名_Scores(
    id int(255) ,
    score decimal
);

insert into a178_分数排名_Scores (id, score)
values
    (1,3.50),
    (2,3.65),
    (3,4.00),
    (4,3.85),
    (5,4.00),
    (6,3.65)
;

select * from a178_分数排名_Scores;
-- count
select
    s1.score,
    (
        select
            count(distinct s2.score)
        from
            a178_分数排名_Scores as s2
        where
            s2.score >= s1.score
    ) as `rank`
from
    a178_分数排名_Scores as s1
order by s1.score desc



-- inner join 和 count
select
    s1.score,
    count(distinct s2.score) as `rank`
from
    a178_分数排名_Scores as s1
    inner join a178_分数排名_Scores s2 on s1.score <= s2.score
group by
    s1.id,
    s1.score
order by s1.score desc
