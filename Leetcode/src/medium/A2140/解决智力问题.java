package medium.A2140;

public class 解决智力问题 {
    public static void main(String[] args) {
        int[][] questions = new int[][]{
                {3,2},
                {4,3},
                {4,4},
                {2,5}
        };
        long l = new 解决智力问题().mostPoints(questions);
        System.out.println(l);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for(int i = n - 1 ; i >= 0 ; i--){
            int step  = questions[i][1] + i + 1;
            // i 题做
            dp[i] =  questions[i][0];
            if(step < n){
                dp[i] += dp [step];
            }
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        return dp[0];
    }
}
