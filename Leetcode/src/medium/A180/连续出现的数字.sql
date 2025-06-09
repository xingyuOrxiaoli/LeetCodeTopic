create table a180_连续出现的数字_Logs(
    id int(255) primary key auto_increment,
    num varchar(255)
);

insert into a180_连续出现的数字_Logs values
                                  (default,1),
                                  (default,1),
                                  (default,1),
                                  (default,2),
                                  (default,1),
                                  (default,2),
                                  (default,2)
;


select distinct
    l1.num as `ConsecutiveNums `
from
    a180_连续出现的数字_Logs as l1,
    a180_连续出现的数字_Logs as l2,
    a180_连续出现的数字_Logs as l3
where
    l1.id = l2.id - 1 and
    l2.id = l3.id - 1 and
    l1.num = l2.num    and
    l2.num = l3.num
;
