
create table a177_第N高的薪水_Employee(
                                           id int(255) primary key ,
                                           salary int(255)
);

insert into a177_第N高的薪水_Employee values
                                           (1,100),
                                           (2,200),
                                           (3,300)
;
# 请注意在 SQL 中，查询中子句的执行顺序通常如下：
#
# FROM 子句：指定从中检索数据的表。
# WHERE 子句：根据指定的条件筛选行。
# GROUP BY 子句：根据指定的列或表达式对行进行分组。
# HAVING 子句：根据条件筛选分组的行。
# SELECT 子句：选择将在结果集中返回的列或表达式。
# ORDER BY 子句：根据指定的列或表达式对结果集进行排序。
# LIMIT/OFFSET 子句：限制结果集中返回的行数。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

    DECLARE m int;
    set m = n - 1;
    RETURN (
        # Write your MySQL query statement below.
            select  distinct
                e.salary
            from
                a177_第N高的薪水_Employee as e
            order by e.salary desc
            limit m , 1
        );
END