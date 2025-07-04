use leetcode;


create table a262_行程和用户_Trips(
    id           int(255),
    client_id    int(255),
    driver_id    int(255),
    city_id      int(255),
    status       enum('completed', 'cancelled_by_driver', 'cancelled_by_client'),
    request_at   varchar(255)
);
drop table a262_行程和用户_Users;
create table a262_行程和用户_Users(
    users_id     int(255),
    banned       enum('Yes', 'No') ,
    role         enum('client', 'driver', 'partner')
);


insert into a262_行程和用户_Trips values
                                 ( 1 , 1 , 10 , 1 , 'completed' , '2013-10-01'),
                                 ( 2 , 2 , 11 , 1 , 'cancelled_by_driver' , '2013-10-01'),
                                 ( 3 , 3 , 12 , 6 , 'completed' , '2013-10-01'),
                                 ( 4 , 4 , 13 , 6 , 'cancelled_by_client' , '2013-10-01'),
                                 ( 5 , 1 , 10 , 1 , 'completed' , '2013-10-02'),
                                 ( 6 , 2 , 11 , 6 , 'completed' , '2013-10-02'),
                                 ( 7 , 3 , 12 , 6 , 'completed' , '2013-10-02'),
                                 ( 8 , 2 , 12 , 12 , 'completed' , '2013-10-03'),
                                 ( 9 , 3 , 10 , 12 , 'completed' , '2013-10-03'),
                                 ( 10 , 4 , 13 , 12 , 'cancelled_by_driver' , '2013-10-03')
;


insert into a262_行程和用户_Users values
                                 ( 1 , 'No' , 'client' ),
                                 ( 2 , 'Yes' , 'client' ),
                                 ( 3 , 'No' , 'client' ),
                                 ( 4 , 'No' , 'client' ),
                                 ( 10 , 'No' , 'driver' ),
                                 ( 11 , 'No' , 'driver' ),
                                 ( 12 , 'No' , 'driver' ),
                                 ( 13 , 'No' , 'driver' )
;


select
    trips.request_at  Day,
    round(
            (
                sum(case status when 'cancelled_by_client' then 1 else 0 end) +
                sum(case status when 'cancelled_by_driver' then 1 else 0 end)
            ) / count(1) , 2
    ) 'Cancellation Rate'
from
    a262_行程和用户_Trips as trips

where
    trips.client_id not in (select users1.users_id from a262_行程和用户_Users  as users1 where users1.banned ='Yes')
    and trips.driver_id not in (select users2.users_id from a262_行程和用户_Users as users2 where users2.banned ='Yes')
    and trips.request_at between '2013-10-01' and '2013-10-03'
group by
    trips.request_at
;
