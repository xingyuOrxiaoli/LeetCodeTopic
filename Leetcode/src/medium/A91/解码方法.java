package medium.A91;

public class 解码方法 {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (int i = 0 ; i < 100; i++) str.append(1);
        System.out.println(str);
        int i = new 解码方法().numDecodings("2611055971756562");
        System.out.println(i);
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        if(s.charAt(0) != '0')  dp[0] = 1;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != '0') dp[i + 1] = dp[i];
            else if(i != 0 && s.charAt(i -1) == '0') return 0;
            if(i != 0 && check(s.charAt(i -1) , s.charAt(i))) dp[i + 1] += dp[i - 1];
        }
        return dp[n];
    }
    private boolean check(char first ,char second){
        return first != '0' && (first == '1' || (first == '2' && second <= '6'));
    }
}
