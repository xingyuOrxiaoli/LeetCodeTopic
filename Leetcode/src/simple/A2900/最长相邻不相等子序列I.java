package simple.A2900;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 最长相邻不相等子序列I {
    public static void main(String[] args) {
        String[] words = {
                "tu","rv","bn"
        };
        int[] groups = ArrayUtils.createArrayOne("[0,0,0]");
        List<String> longestSubsequence = new 最长相邻不相等子序列I().getLongestSubsequence(words, groups);
        System.out.println(longestSubsequence);
    }
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        int group = groups[0];
        res.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if(group != groups[i]) {
                res.add(words[i]);
                group = groups[i];
            }
        }

        return res;
    }

}
