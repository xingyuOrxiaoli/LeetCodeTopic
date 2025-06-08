package simple.A1018;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 可被5整除的二进制前缀 {
    public static void main(String[] args) {
     int[] nums = ArrayUtils.createArrayOne("[0,1,1]");
        List<Boolean> res = new 可被5整除的二进制前缀().prefixesDivBy5(nums);
        System.out.println(res);
    }
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int n = nums.length , t = 0;
        for (int i = 0; i < n; i++) {
            t = ((t << 1 ) + nums[i]) % 5;
            res.add(t == 0);
        }
        return res;
    }
}
