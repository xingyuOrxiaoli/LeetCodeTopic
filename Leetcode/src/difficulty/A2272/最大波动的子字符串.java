package difficulty.A2272;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 最大波动的子字符串 {

    public static void main(String[] args) {
        int i = new 最大波动的子字符串().largestVariance("aababbb");
        System.out.println(i);
    }
    public int largestVariance(String s) {
        // 参考LeetCode官方给的题解 笔记记录
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i ++) map.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);

        int res = 0;
        for (char ch1 : map.keySet() ){
            for (char ch2 : map.keySet()){
                if(ch1 != ch2){
                    // 随便选择两个字符  ch1 为最多字符 ch2为最少字符
                    List<Integer> list1 = map.get(ch1);
                    List<Integer> list2 = map.get(ch2);

                    // 从Math.min(list1,list2) ~ Math.max(list1,list2) 中的元素进行递增
                    int i = 0 , j = 0;
                    // f表示当前遍历到的元素作为结尾，最大的值
                    // g表示当前遍历到的元素作为结尾，并且里面有至少一个-1，的最大值
                    int f = 0,g = Integer.MIN_VALUE;
                    while(i < list1.size() || j < list2.size()){
                        // list2 遍历结束循环为结束则 元素为list1中的元素相当于遇到 +1
                        // 如果list1当前的元素小于list2当前的元素小 则先遍历到list1的元素 则相当于遇到 +1
                        if( j == list2.size() || (i < list1.size() && list1.get(i) < list2.get(j))){
                            f = Math.max(f,0) + 1;
                            g = g + 1;
                            i ++;
                        }else{
                            // list1 遍历到头
                            // list2 的元素值小于list1的元素值
                            g = Math.max(Math.max(f,g),0) -1;
                            f = Math.max(f,0)-1;
                            j ++;
                        }
                        res = Math.max(res,g);
                    }
                }
            }
        }

        return res;
    }
}
