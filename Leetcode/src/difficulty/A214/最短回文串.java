package difficulty.A214;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class 最短回文串 {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder("123");
        res.insert(1,"-");
        System.out.println(res.toString());
        String s = new 最短回文串().shortestPalindrome("babbbabbaba");
        System.out.println(s);
    }
    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] kmp = new int[n];
        Arrays.fill(kmp, - 1);
        for(int i = 1 ; i < n ; i ++){
            int j = kmp[i  - 1];
            while(j != -1 && s.charAt(j + 1 ) != s.charAt(i)){
                j = kmp[j];
            }
            if(s.charAt(j + 1) == s.charAt(i)){
                kmp[i] = j + 1;
            }
        }
        int best = -1 ;
        for(int i = n - 1 ; i > - 1 ; i --){
            while(best != - 1 && s.charAt(best + 1 ) != s.charAt(i)){
                best = kmp[best];
            }
            if(s.charAt(best + 1) == s.charAt(i)){
                best ++;
            }
        }

        StringBuilder res = new StringBuilder();
        if(best != n - 1){
            res.append(s.substring(best + 1));
            res.reverse();
        }
        res.append(s);
        return res.toString();
    }
}
