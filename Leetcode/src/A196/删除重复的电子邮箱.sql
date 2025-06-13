
create table A196_删除重复的电子邮箱_Person(
  id int(255) primary key,
  email varchar(255)
);

insert into A196_删除重复的电子邮箱_Person values
                                      (1,'john@example.com'),
                                      (2,'bob@example.com'),
                                      (3,'john@example.com')
;

delete p1 from
              A196_删除重复的电子邮箱_Person  p1,
              A196_删除重复的电子邮箱_Person  p2
where
    p1.email = p2.email and p1.id > p2.id
;