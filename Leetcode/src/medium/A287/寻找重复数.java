package medium.A287;

public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        int left = nums[0] , right = nums[nums[0]];
        while(left != right){
            left = nums[left];
            right = nums[nums[right]];
        }
        left = 0 ;
        while (left != right){
            left = nums[left];
            right = nums[right];
        }
        return left;
    }


}
