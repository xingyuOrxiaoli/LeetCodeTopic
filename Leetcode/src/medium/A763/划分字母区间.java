package medium.A763;


import java.util.*;

public class 划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        int[] ends = new int[26];
        int n = s.length() , left = 0 , right = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < n; i ++) ends[s.charAt(i) - 'a'] = i;
        for(int i = 0 ; i < n ; i ++){
            right = Math.max(right, ends[s.charAt(i) - 'a']);
            if(i == right){
                res.add(right - left  + 1);
                left = right + 1;
            }
        }
        return res;
    }
}
