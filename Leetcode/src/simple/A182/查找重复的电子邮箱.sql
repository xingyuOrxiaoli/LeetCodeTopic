create table A182_查找重复的电子邮箱_Person
(
    id  int(255) primary key ,
    email varchar(255)
);

insert into A182_查找重复的电子邮箱_Person values
                                               (1,'a@b.com'),
                                               (2,'c@b.com'),
                                               (3,'a@b.com')
;

-- 方法1 使用group by
select persion2.email from
                         (
                             select persion1.email , count(persion1.email) as count
                             from A182_查找重复的电子邮箱_Person as persion1
                             group by persion1.email
                         ) as persion2
where persion2.count > 1;


-- 方法2 使用group by 和 having 条件
select
    distinct
    persion.email as `Email`
from
    A182_查找重复的电子邮箱_Person as persion
group by persion.email
having count(*) > 1


