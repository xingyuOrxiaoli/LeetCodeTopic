-- empId


use leetcode;

create table a577_员工奖金_Employee(
    empId int(125),
    name varchar(244),
    supervisor int(125),
    salary int(125)
);

create table a577_员工奖金_Bonus(
    empId int(125),
    bonus int(125)
);