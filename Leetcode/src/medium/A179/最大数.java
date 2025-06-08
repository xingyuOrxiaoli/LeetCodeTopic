package medium.A179;

import utils.ArrayUtils;

import java.util.*;

public class 最大数 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[3,30,34,5,9]");
        String s = new 最大数().largestNumber(nums);
        System.out.println(s);
    }
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        int n = nums.length;
        Integer[] newNums = new Integer[n];
        for (int i = 0; i < n; i++) newNums[i] = nums[i];
        Arrays.sort(newNums, (x, y )->{
            long val1 = 10 , val2 = 10;
            while(val1 <= x) val1 *= 10;
            while(val2 <= y) val2 *= 10;
            val1 *= y;
            val1 += x;

            val2 *= x;
            val2 += y;
            if(val1 > val2) return 1;
            return  -1;
        });
        if(newNums[0] == 0) return "0";
        for (Integer num : newNums) res.append(num);
        return res.toString();
    }
}
