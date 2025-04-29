package difficulty.A87;

import java.util.*;

public class 扰乱字符串 {


    public static void main(String[] args) {
        boolean scramble = new 扰乱字符串().isScramble("great", "rgeat");
        System.out.println(scramble);
    }


    // 暴力 时间超时  abcdefghijklmnopq    efghijklmnopqcadb
    public boolean isScramble(String s1, String s2) {
       if(s1.length() == 1) return s1.equals(s2);
       int n1 = s1.length() , n2 = s2.length();
       boolean res = false;
       for(int i = 1 ; i <= n1 - 1 ; i ++){
           String x1 = s1.substring(0,i) , y1 = s1.substring(i , n1);
           // s2的拆解
           String x2_1 = s2.substring(0,i) , y2_1 = s2.substring(i , n1);
           res = res  || (isScramble(x1, x2_1) && isScramble(y1,y2_1));
           if(res) break;

           String x2_2 = s2.substring(n2 - i ,n2) , y2_2 = s2.substring(0 , n2 - i);
           res = res  || (isScramble(x1, x2_2) && isScramble(y1,y2_2));
           if(res) break;
       }
       return res;
    }

    // 记忆化搜索  进行优化
    boolean[][] dp = new boolean[30][30] , udp = new boolean[30][30] ;
    public boolean isScramble2(String s1, String s2) {
        if(s1.length() == 1) return s1.equals(s2);
        int n1 = s1.length() , n2 = s2.length();
        boolean res = false;
        for(int i = 1 ; i <= n1 - 1 ; i ++){
            String x1 = s1.substring(0,i) , y1 = s1.substring(i , n1);

            // 0 - i  dp[0][i] = dp[0][i - 1] && s1[i] == s2[i]
            String x2_1 = s2.substring(0,i) , y2_1 = s2.substring(i , n1);
            res = res  || (isScramble(x1, x2_1) && isScramble(y1,y2_1));
            if(res) break;

            String x2_2 = s2.substring(n2 - i ,n2) , y2_2 = s2.substring(0 , n2 - i);
            res = res  || (isScramble(x1, x2_2) && isScramble(y1,y2_2));
            if(res) break;
        }

        return res;
    }

}

// LeetCode官方解
class Solution {
    // 记忆化搜索存储状态的数组
    // -1 表示 false，1 表示 true，0 表示未计算
    int[][][] memo;
    String s1, s2;

    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        this.memo = new int[length][length][length + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, length);
    }

    // 第一个字符串从 i1 开始，第二个字符串从 i2 开始，子串的长度为 length，是否和谐
    public boolean dfs(int i1, int i2, int length) {
        if (memo[i1][i2][length] != 0) {
            return memo[i1][i2][length] == 1;
        }

        // 判断两个子串是否相等
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            memo[i1][i2][length] = 1;
            return true;
        }

        // 判断是否存在字符 c 在两个子串中出现的次数不同
        if (!checkIfSimilar(i1, i2, length)) {
            memo[i1][i2][length] = -1;
            return false;
        }

        // 枚举分割位置
        for (int i = 1; i < length; ++i) {
            // 不交换的情况
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
            // 交换的情况
            if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
        }

        memo[i1][i2][length] = -1;
        return false;
    }

    public boolean checkIfSimilar(int i1, int i2, int length) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = i1; i < i1 + length; ++i) {
            char c = s1.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = i2; i < i2 + length; ++i) {
            char c = s2.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}