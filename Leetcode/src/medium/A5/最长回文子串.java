package medium.A5;

public class 最长回文子串 {
    public static void main(String[] args) {
        String s = new 最长回文子串().longestPalindrome("babad");
        System.out.println(s);
    }
    public String longestPalindrome(String s) {
        // 参考题解的出来的答案
        int length = s.length();
        if(length == 1) return s;

        int end = 0;
        int start = 0;

        boolean[][] dp = new boolean[length][length];
        for(int i = 0 ;i < length ; i++) dp[i][i] = true;

        char[] ch = s.toCharArray();
        for(int j = 1; j < length ; j++ )
            for(int i = 0 ; i < j ; i++){
                if(ch[i] != ch[j]) dp[i][j] = false;
                else if(j - i < 3) dp[i][j] = true;
                else dp[i][j] = dp[i + 1][j - 1];

                if(dp[i][j] && j - i > end - start){
                    end  = j;
                    start = i;
                }
            }
        return s.substring(start,end+1);

    }
}
