package medium.A139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 单词拆分 {
    public static void main(String[] args) {
        String[] str = new String[]{
                "apple","pen"
        };
        List<String> wordDict = new ArrayList<String>();
        for (String s : str) {
            wordDict.add(s);
        }
        boolean b = new 单词拆分().wordBreak("applepenapple", wordDict);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> dict = new HashSet<>();
        dict.add("");
        wordDict.forEach(word->dict.add(word));
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i  = 1 ; i <= n ; i ++){
            for(int j = i ; j > 0 ; j --){
                if((i == j && dict.contains(s.substring(0,j)))  || (i != j && dp[j] && dict.contains(s.substring(j,i)))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
