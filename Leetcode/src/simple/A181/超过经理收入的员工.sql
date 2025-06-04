select
    e1.name as Employee
from
             Employee as e1 ,
             Employee as e2
         where
             e1.managerId = e2.id
             and e1.salary > e2.salary

;

-- 使用join语句

select
    e1.name as Employee
from Employee as e1
    join Employee as e2
    on  e1.managerId = e2.id
    and  e1.salary > e2.salary
;
