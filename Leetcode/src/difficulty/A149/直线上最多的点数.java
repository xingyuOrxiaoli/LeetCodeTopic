package difficulty.A149;

import utils.ArrayUtils;

import java.util.HashMap;

public class 直线上最多的点数 {
    public static void main(String[] args) {
        int[][] points = ArrayUtils.createArrayTwo("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]");
        int i = new 直线上最多的点数().maxPoints(points);
        System.out.println(i);
    }
    public int maxPoints(int[][] points) {
        int res = 1 , n = points.length;

        for(int i = 0 ; i < n ; i ++){
            HashMap<Double , Integer> numberK = new HashMap<>();
            for(int j = 0 ; j < n ; j ++){
                if(i == j) continue;
                double x = points[i][0] - points[j][0] , k = Double.MAX_VALUE;
                if(x != 0) k = (double) ((points[i][1] - points[j][1]) / x);
                numberK.put(k , numberK.getOrDefault(k,0) + 1);
                res = Math.max(res , 1 + numberK.get(k));
            }
        }
        return res;
    }
}
