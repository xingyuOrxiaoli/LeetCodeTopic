create table a197_上升的温度_Weather(
    id int(255) primary key,
    recordDate date,
    temperature int(255)
);

select  * from a197_上升的温度_Weather;

insert into a197_上升的温度_Weather values
                                   (1,'2015-01-01',10),
                                   (2,'2015-01-02',25),
                                   (3,'2015-01-03',20),
                                   (4,'2015-01-04',30)
;

select
    w1.id
from
    a197_上升的温度_Weather w1
join
        a197_上升的温度_Weather w2
on
    datediff(w1.recordDate,w2.recordDate) = 1
# timestampdiff(day,w1.recordDate,w2.recordDate) = -1
where
    w1.temperature > w2.temperature
;