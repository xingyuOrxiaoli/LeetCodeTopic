package medium.A2311;

public class 小于等于K的最长二进制子序列 {
    public static void main(String[] args) {

    }

    public int longestSubsequence(String s, int k) {
        int res = 0  , n = s.length() , sum = 0 , bitUp = (int)(Math.log(k) / Math.log(2)) + 1;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt( n -  1 - i);
            if(ch == '1'){
                if(i < bitUp && (1 << i) + sum <= k){
                    res ++;
                    sum  += (1 << i);
                }
            }else res ++;
        }
        return res;
    }
}
