package medium.A3403;

import java.util.ArrayList;
import java.util.List;

public class 从盒子中找出字典序最大的字符串I {
    public static void main(String[] args) {
        String s = new 从盒子中找出字典序最大的字符串I().answerString2("dbca", 2);
        System.out.println(s);
    }
    // 暴力解法
    public String answerString1(String word, int numFriends) {
        if (numFriends == 1) return word;
        String res = "";
        int n = word.length();
        for(int i = 0 ; i < n ; i ++){
            String temp = word.substring(i,Math.min(i + n - numFriends + 1 , n));
            if(res.compareTo(temp) <= 0) res = temp;
        }
        return res;
    }
    // 双指针
    public String answerString2(String word, int numFriends) {
        if (numFriends == 1) return word;

        int left = 0 , right = 1 , n = word.length();
        while (right < n) {
            int step = 0;
            while(right + step < n && word.charAt(left + step) == word.charAt(right + step)) step++;

            if(right + step < n && word.charAt(left + step) < word.charAt(right + step)){
                int temp = left;
                left = right;
                right = Math.max(right + 1 , temp + step + 1);
            }else right = right + step + 1;
        }

        System.out.println(left);
        return word.substring(left , Math.min(n, left + n - numFriends + 1));
    }
}
