package medium.A128;

import com.sun.javafx.collections.MappingChange;
import utils.ArrayUtils;
import java.util.*;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[] num = ArrayUtils.createArrayOne("[100,4,200,1,3,2]");
        int i = new 最长连续序列().longestConsecutive(num);
        System.out.println(i);
    }
    public int longestConsecutive(int[] nums) {
        int res = 0 , temp = 0;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);
        for (Integer value : set) {
            temp ++;
            if(!set.contains(value + 1)){
                res = Math.max(res, temp);
                temp = 0;
            }
        }
        return res;
    }
}
