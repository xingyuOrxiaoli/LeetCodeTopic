package medium.A438;

import utils.TreeNode;

import java.lang.annotation.Target;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[]  p_count = new int[26];
        boolean[] p_flag = new boolean[26];
        for (char c : p.toCharArray()) {
            p_flag[c - 'a'] = true;
            p_count[c - 'a']++;
        }
        int m = s.length() , n = p.length() , no_same = n;
        if(m < n ) return res;
        for (int i = 0; i < n ; i ++){
            char ch = s.charAt(i);
            if(p_count[ch - 'a'] > 0) no_same--;
            p_count[ch - 'a']--;
        }
        if(no_same == 0) res.add(0);
        for(int i = n  , j  = 0; i <  m ; i ++, j ++){
            char right = s.charAt(i) , left = s.charAt(j);
            if(p_count[left - 'a'] >= 0){
                no_same ++;
            }
            p_count[left - 'a']++;
            if(p_count[right - 'a'] > 0){
                no_same --;
            }
            p_count[right - 'a']--;
            if(no_same == 0) res.add(j + 1);
        }
        // if(no_same == 0) res.add(m - n);
        return res;
    }

}
