package difficulty.A76;

import java.util.Arrays;

public class 最小覆盖子串 {


    public static void main(String[] args) {
        String s = new 最小覆盖子串().minWindow("ADOBECODEBANC", "FDSAFDSFDSAFSAFADSF");
        int value = 'z';
        System.out.println(value);
        value = 'A';
        System.out.println(value);
        System.out.println(122 - 65 + 1);
        System.out.println(s);
    }
    public String minWindow(String s, String t) {
        String res = "";
//        s = s.toUpperCase();
//        t = t.toUpperCase();
        int s_n = s.length() , t_n = t.length() , left = 0 , right = 0; ;
        int[] t_sum = new int[58] , s_index = new int[s_n] , s_sum  = new int[58] ;
        for (int i = 0; i < t_n; i++) {
            if(t_sum[t.charAt(i) - 'A'] == 0){
                t_sum[t.charAt(i) - 'A']++;
                s_sum[t.charAt(i) - 'A']++;
            }
            t_sum[t.charAt(i) - 'A'] ++;
        }
        for (int i = 0; i < s_n; i++) {
            int index = s.charAt(i) - 'A';
            if (t_sum[index] == 0) continue;
            if(t_sum[index] > s_sum[index]) t_n --;
            s_sum[index] ++;
            s_index[right++] = i;
            if(t_n == 0){
                while(s_sum[s.charAt(s_index[left]) - 'A'] > t_sum[s.charAt(s_index[left]) - 'A'])
                    s_sum[s.charAt(s_index[left++]) - 'A'] --;
                if("".equals(res) || res.length() >= i - s_index[left] + 1)
                    res = s.substring(s_index[left],i + 1);
            }
        }
        return res;
    }


    // 第二次写
    public String minWindow_2(String s, String t) {
        int l =  0 , r = 0 , sum =  0;
        int[] t_sum = new int[58]  , s_sum = new int[58]  , s_index = new int[s.length()] ;
        for(int i = 0 ; i < t.length() ; i ++) t_sum[t.charAt(i) - 'A'] ++;
        String res = "" ;
        for(int i = 0  ; i < s.length() ; i++){
            if(t_sum[s.charAt(i) - 'A'] == 0) continue;
            if(t_sum[s.charAt(i) - 'A'] > s_sum[s.charAt(i) - 'A']) sum ++ ;
            s_sum[s.charAt(i) - 'A'] ++;
            s_index[r ++] = i;
            if(sum == t.length()){
                while(s_sum[s.charAt(s_index[l])  - 'A'] > t_sum[s.charAt(s_index[l])  - 'A']) s_sum[s.charAt(s_index[l++])  - 'A'] --;
                if("".equals(res) || res.length() >= i - s_index[l] + 1) res = s.substring(s_index[l] , i + 1);
            }
        }
        return res;
    }
}
