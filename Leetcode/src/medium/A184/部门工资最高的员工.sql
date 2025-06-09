create table a184_部门工资最高的员工_Employee(
    id      int(255)     primary key,
    name    varchar(255) ,
    salary  int(255)     ,
    departmentId int(255)
);

create table a184_部门工资最高的员工_Department(
    id      int(255)    primary key,
    name    varchar(255)
);

insert into a184_部门工资最高的员工_Employee values
                                        (1,'Joe',70000,1),
                                        (2,'Jim',90000,1),
                                        (3,'Henry',80000,2),
                                        (4,'Sam',60000,2),
                                        (5,'Max',90000,1)
;

insert into a184_部门工资最高的员工_Department values
                                          (1,'IT'),
                                          (2,'Sales')
;


select
    department.name as `Department` ,
    employee.name   as `Employee`   ,
    employee.salary as `Salary`
from

    a184_部门工资最高的员工_Employee   as employee
        join  a184_部门工资最高的员工_Department as department
            on
                employee.departmentId = department.id
where
    (employee.departmentId , salary)
    in
        (
            select
                employee2.departmentId , MAX(employee2.salary)
            from
                a184_部门工资最高的员工_Employee as employee2
            group by employee2.departmentId
        )
;

