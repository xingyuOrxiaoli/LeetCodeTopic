package medium.A1297;

import java.util.*;

public class 子串的最大出现次数 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0 , n = s.length() , ch_count = 0;
        HashMap<String, Integer> map = new HashMap<>(n + 1);
        int[] count = new int[26];
        for(int i  = 0 ; i < minSize - 1 ; i ++){
            count[s.charAt(i) - 'a']++;
            if(count[s.charAt(i) - 'a'] == 1) ch_count ++;
        }
        for(int i = minSize - 1; i < n ; i++){
            count[s.charAt(i) - 'a']++;
            if(count[s.charAt(i) - 'a'] == 1) ch_count ++;

            if(ch_count <= maxLetters){
                String t = s.substring(i - minSize + 1  , i + 1);
                map.put(t, map.getOrDefault(t, 0) + 1);
                res = Math.max(res, map.get(t));
            }

            count[s.charAt(i - minSize + 1) - 'a'] --;
            if(count[s.charAt(i - minSize + 1) - 'a'] == 0) ch_count --;
        }

        return res;
    }
}
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        /**
             子串长度只需要考虑minSize就可以了，因为长的串肯定包含短的串
             问题转化 -》  定长子串问题
         */

        int n = s.length();
        //统计子串出现的个数
        Map<String,Integer> map = new HashMap<>();
        //统计子串中不同字母的个数
        Map<Character,Integer> cnt = new HashMap<>();
        int count = 0;
        int ans = 0;

        char[] c = s.toCharArray();
        //初始化窗口状态，确保下一个加入后就形成窗口
        for(int i = 0; i < minSize-1; ++i){
            cnt.put(c[i],cnt.getOrDefault(c[i],0)+1);
            if(cnt.get(c[i])==1){
                ++count;
            }
        }

        for(int i = minSize-1; i < n; ++i){
            //1.进入窗口
            cnt.put(c[i],cnt.getOrDefault(c[i],0)+1);
            if(cnt.get(c[i])==1){
                ++count;
            }

            //2.更新数据
            if(count <= maxLetters){
                String subStr = s.substring(i-minSize+1,i+1);
                map.put(subStr,map.getOrDefault(subStr,0)+1);
                ans = Math.max(ans,map.get(subStr));
            }

            //3.离开窗口
            cnt.put(c[i-minSize+1],cnt.get(c[i-minSize+1])-1);//将窗口中第一个字符删掉
            if(cnt.get(c[i-minSize+1]) == 0){//如果删掉的字符值变为0，将其从整个map中删掉
                cnt.remove(c[i-minSize+1]);
                --count;
            }

        }
        return ans;
    }
}