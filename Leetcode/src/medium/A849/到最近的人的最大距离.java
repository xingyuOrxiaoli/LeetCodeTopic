package medium.A849;

public class 到最近的人的最大距离 {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length , res = 1;
        int[] left = new int[n] , right = new int[n];
        right[n - 1] = Integer.MAX_VALUE;
        for(int i = n - 2 ; i > -1 ; i --){
            if(seats[i] == 1) right[i] = 0 ;
            else if(seats[i + 1] == 1) right[i] = 1;
            else right[i] = right[ i + 1 ] + 1;
        }
        left[0] = Integer.MAX_VALUE;
        res = right[0];
        for(int i = 1 ; i < n ; i ++){
            if(seats[i] == 1) left[i] = 0 ;
            else if(seats[i - 1] == 1) left[i] = 1;
            else left[i] = left[i - 1] + 1;

            if(seats[i] == 0 ) res = Math.max(res , Math.min(left[i] , right[i]));
        }
        return res;
    }
}
