package medium.A2438;

import java.util.ArrayList;
import java.util.List;

public class 二的幂数组中查询范围内的乘积 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
    public int[] productQueries(int n, int[][] queries) {
        int m = queries.length  , temp = 1;
        int[] res = new int[m] ;
        List<Integer> list = new ArrayList<>(32);
        while(n != 0){
            if((n & 1) == 1) list.add(temp);
            temp <<= 1;
            n >>= 1;
        }

        for (int i = 0; i < queries.length; i++) {
            long cur = 1;
            for(int j = queries[i][0] ; j <= queries[i][1] ; j ++)
                cur = (cur * list.get(j)) % 1000000007;
            res[i] = (int)cur;
        }

        return res;
    }
}
