package difficulty.A2338;

import java.util.*;

public class 统计理想数组的数目 {

    public static void main(String[] args) {
        int i = new 统计理想数组的数目().idealArrays1(10000, 10000);
        System.out.println(i);
    }

    // 方法1 ： 内存超了
    int mod = 1000000007;
    public int idealArrays1(int n, int maxValue) {
        int[][] dp = new int[n][maxValue];
        List<Integer> list = null;
        Map<Integer, List<Integer>> map  =new HashMap<>();
        for (int j = 1 ; j <= maxValue ; j++){
            int x = j;
            while(x <= maxValue){
                dp[1][x - 1] ++;
                list = map.getOrDefault(x - 1, new ArrayList<>());
                list.add(j);
                if(list.size() == 1) map.put(x - 1, list);
                x += j;
            }
        }
        for (int i = 1; i < n; i++) dp[i][0] = 1;

        for (int i = 2 ; i < n ; i++)
            for (int j = 1; j < maxValue; j++){
                list = map.get(j);
                for (Integer value : list)
                    dp[i][j] = (dp[i][j] + dp[i - 1][value - 1]) % mod;
            }
        int res = 0 ;
        for(int  j = 0 ; j < maxValue ; j++) res = (res + dp[n - 1][j]) % mod;
        return res;
    }

}
