package simple.A3024;

import utils.ArrayUtils;

import java.util.Arrays;

public class 三角形类型 {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[3,3,3]");
        String s = new 三角形类型().triangleType(nums);
        System.out.println(s);
    }

    public String triangleType(int[] nums) {

        if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
        else if(Arrays.stream(nums).sum() <= Arrays.stream(nums).max().getAsInt() * 2) return "none";
        else if(nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) return "isosceles";
        else return "scalene";
    }
}
