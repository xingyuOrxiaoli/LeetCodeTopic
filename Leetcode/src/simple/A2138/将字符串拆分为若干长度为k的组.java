package simple.A2138;

import java.util.Arrays;

public class 将字符串拆分为若干长度为k的组 {
    public static void main(String[] args) {

    }
    public String[] divideString(String s, int k, char fill) {
        int n = s.length() , m = (n + k - 1) / k;
        String[] res = new String[m];
        Arrays.fill(res, "");
        for(int i = 0 ; i < n ; i ++){
            int j = i / k ;
            res[j] += s.charAt(i);
        }
        int temp = n % k ;
        if(temp != 0){
            for(int i = temp ;i < k ; i ++) res[m - 1] += fill;
        }
        return res;
    }
}
