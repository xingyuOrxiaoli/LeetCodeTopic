package medium.A81;

public class 搜索旋转排序数组II {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        boolean search = new 搜索旋转排序数组II().search2(nums, 0);
        System.out.println(search);
    }


    // 遍历整个数组进行暴力接
    public boolean search(int[] nums, int target) {

        if(nums[0] > target && target> nums[nums.length - 1]) return false;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == target) return true;
        return false;
    }

    // TODO 二分代写  两种写法 一种以 mid作为分割 一种以left/rigth作为判断分割 移动
    public boolean search2(int[] nums, int target) {

        if(nums[0] > target && target> nums[nums.length - 1]) return false;

        /**
         *
         */
        int left = 0, right = nums.length - 1 , mid = (left + right) >> 1;
        while (left <= right) {
            if (nums[mid] == target)  return true;

//            if


            mid = (left + right) >> 1;
        }


        return false;
    }
}
