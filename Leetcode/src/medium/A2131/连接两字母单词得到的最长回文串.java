package medium.A2131;

import java.util.*;

public class 连接两字母单词得到的最长回文串 {
    public static void main(String[] args) {
        String[] words = {
                "bb","bb"
        };
        int i = new 连接两字母单词得到的最长回文串().longestPalindrome(words);
        System.out.println(i);
    }
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word , map.getOrDefault(word , 0) + 1);
        }
        int res = 0 , same = 0;
        for(String word : words) {
            if(map.get(word) ==0 ) continue;
            String key = new StringBuffer(word).reverse().toString();
            int value = map.getOrDefault(key , 0);
            if(key.equals(word) && ((value & 1) == 1)){
                same = 2;
                value --;
            }
            if(value > 0){
                map.put(key , value - 1);
                map.put(word, map.get(word) - 1);
                res += 4;
            }
        }

        return res + same;
    }
}
