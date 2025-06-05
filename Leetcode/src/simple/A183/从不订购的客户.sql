create table A183_从不订购的客户_Customers
(
    id          int(255) primary key ,
    name        varchar(255)
);

create table A183_从不订购的客户_Orders
(
    id          int(255) primary key ,
    customerId  int(255)
);


insert into A183_从不订购的客户_Customers values
                                               (1,'Joe'),
                                               (2,'Henry'),
                                               (3,'Sam'),
                                               (4,'Max')
;
insert into A183_从不订购的客户_Orders values
                                              (1,3),
                                              (2,1)
;

--  方法1

select
    customers.name as `Customers`
from
    A183_从不订购的客户_Customers as customers

where
    customers.id not in
    (
        select orders.customerId from A183_从不订购的客户_Orders    as orders
    );

--  方法2

select
    customers.name as `Customers`
from
    A183_从不订购的客户_Customers as customers
left join
        A183_从不订购的客户_Orders as orders
on
    customers.id = orders.customerId
where
    orders.customerId is NULL

where
    customers.id not in
    (
        select orders.customerId from A183_从不订购的客户_Orders    as orders
    )

