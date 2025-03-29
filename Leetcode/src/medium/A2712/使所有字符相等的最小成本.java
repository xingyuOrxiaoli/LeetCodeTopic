package medium.A2712;

public class 使所有字符相等的最小成本 {
    public static void main(String[] args) {
        long l = new 使所有字符相等的最小成本().minimumCost("0011");
        System.out.println(l);
    }
    public long minimumCost(String s) {
        int length = s.length();
        long[][] dp = new long[length + 10][2];
        char[] ch =  s.toCharArray();
        long res = Long.MAX_VALUE;
        for(int i = length - 1; i >= 0 ; i--){
            if(ch[i] == '1'){
                dp[i][1] =  dp[i + 1][1];
                dp[i][0] =  dp[i + 1][1] + length - i;
            }else{
                dp[i][1] =  dp[i + 1][0] + length - i;
                dp[i][0] =  dp[i + 1][0];
            }
        }
        long temp1 = 0;
        long temp2 = 0;
        for(int i = 0 ; i < length ; i++){
            if(ch[i] == '1'){
                temp1 = temp2 + i + 1;
            }else{
                temp2 = temp1 + i + 1;
            }
            res = Math.min(res,Math.min(temp1 + dp[i + 1][0], temp2 + dp[i + 1][1]));
        }

        return res;
    }
}
