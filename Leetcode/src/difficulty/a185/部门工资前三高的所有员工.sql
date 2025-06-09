create table a185_部门工资前三高的所有员工_Employee(
                                                 id      int(255)     primary key,
                                                 name    varchar(255) ,
                                                 salary  int(255)     ,
                                                 departmentId int(255)
);

create table a185_部门工资前三高的所有员工_Department(
                                                   id      int(255)    primary key,
                                                   name    varchar(255)
);

insert into a185_部门工资前三高的所有员工_Employee values
                                                 (1,'Joe',70000,1),
                                                 (2,'Jim',90000,1),
                                                 (3,'Henry',80000,2),
                                                 (4,'Sam',60000,2),
                                                 (5,'Max',90000,1)
;

insert into a185_部门工资前三高的所有员工_Department values
                                                   (1,'IT'),
                                                   (2,'Sales')
;

select
    department.name as `Department` ,
    employee.name   as `Employee`   ,
    employee.salary as `Salary`
from
    a185_部门工资前三高的所有员工_Employee as `employee`
        join a185_部门工资前三高的所有员工_Department as `department`
            on employee.departmentId = department.id
where
    3 > (
            select
                count(DISTINCT employee2.salary)
            from
                a185_部门工资前三高的所有员工_Employee as `employee2`
            where
                employee2.salary > employee.salary and
                employee.departmentId = employee2.departmentId
        )
;