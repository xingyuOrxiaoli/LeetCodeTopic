package medium.A274;

public class H指数 {



    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] dp = new int[1001];
        for (int i = 0; i < n; i++) dp[citations[i]]++;
        int res = 0 ;
        for(int i = 1000 ; i > -1 ; i --){
            if(res > i) break;
            if(dp[i] == 0) continue;
            if(res <= i) res += Math.min(dp[i] , i - res);
        }

        return res;
    }
}
