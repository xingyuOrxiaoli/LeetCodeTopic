select
    sum(ride.distance) as  travelled_distance
from
    Users user
left join
        Rides ride on user.id = ride.user_id