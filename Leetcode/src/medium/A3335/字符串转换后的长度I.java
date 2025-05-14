package medium.A3335;

public class 字符串转换后的长度I {

    public static void main(String[] args) {
        int i = new 字符串转换后的长度I().lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517);
        System.out.println(i);
    }
    int mod = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        long res = 0 ;
        int[] sum = new int[26];
        for (int i = 0; i < s.length(); i++) sum[s.charAt(i)-'a']++;

        for (int i = 0 ; i < t ; i++){
            int temp = sum[0];
            for(int j = 1 ; j < 26 ; j ++){
                temp   = temp ^ sum[j];
                sum[j] = sum[j] ^ temp;
                temp   = temp ^ sum[j];
            }
            sum[0]  = temp;
            sum[1] = (int) ((long)(temp + sum[1]) % mod);
        }

        for(int i =0 ; i < 26 ; i ++) {
            res += sum[i];
            res %= mod;
        }
        return (int) res;
    }
}
