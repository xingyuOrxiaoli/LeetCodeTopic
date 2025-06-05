use leetcode ;

create table A175_组合两个表_Person
(
    PersonId  int(255) primary key ,
    FirstName varchar(255) ,
    LastName  varchar(255)
);
create table A175_组合两个表_Address
(
    AddressId int(255) primary key ,
    PersonId  int(255),
    City      varchar(255) ,
    State     varchar(255)
);
insert into A175_组合两个表_Person values
                                  (1,'Wang','Allen'),
                                  (2,'Alice','Bob')
;
insert into A175_组合两个表_Address values
                                       (1,2,'New York City','New York'),
                                       (2,3,'Leetcode','California')
;
-- 方法1 题解
select
    persion.FirstName as firstName,
    persion.LastName  as lastName ,
    address.City      as city     ,
    address.State     as state

from
    a175_组合两个表_person  as persion
        left outer join
    a175_组合两个表_address as address
    on persion.PersonId = address.PersonId
;
