package medium.A2901;

import utils.ArrayUtils;

import java.util.*;

public class 最长相邻不相等子序列II {

    public static void main(String[] args) {
        String[] words = {
                "bab","dab","cab"
        };
        int[] groups = ArrayUtils.createArrayOne("[1,2,2]");
        List<String> wordsInLongestSubsequence = new 最长相邻不相等子序列II().getWordsInLongestSubsequence(words, groups);
        System.out.println(wordsInLongestSubsequence);
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length ,maxIndex = 0;
        int[] dp = new int[n] , pre = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(pre,-1);

        for (int i = 1; i < n; i++) {
            for(int j = 0 ; j < i ; j ++){
                if(groups[j] != groups[i] && dp[i] < dp[j] + 1 && check(words[i],words[j])){
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
                if(dp[i] > dp[maxIndex]) maxIndex = i;
            }
        }
        List<String> res = new ArrayList<>();
        while(maxIndex != -1){
            res.add(0,words[maxIndex]);
            maxIndex = pre[maxIndex];
        }

        return res;
    }
    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
