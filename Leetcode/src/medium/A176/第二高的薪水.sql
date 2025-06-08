
create table a176_第二高的薪水_Employee(
    id int(255) primary key ,
    salary int(255)
);

insert into a176_第二高的薪水_Employee values
                                     (1,100),
                                     (2,200),
                                     (3,300)
;

-- 一页一个薪资  选择第二页 下标是从0开始
select
    (
        select DISTINCT
            e.salary
        from
            a176_第二高的薪水_Employee as e
        order by e.salary DESC
        LIMIT 1 OFFSET 1
    ) as `SecondHighestSalary`;


-- 使用IFNULL和LIMIT字句
select
    IFNULL(
            (
                select DISTINCT e.salary
                from
                    a176_第二高的薪水_Employee AS e
                order by e.salary DESC
                LIMIT 1 OFFSET 1
            ), NULL
    ) AS `SecondHighestSalary`