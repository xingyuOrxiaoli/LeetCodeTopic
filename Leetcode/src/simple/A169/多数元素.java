package simple.A169;

public class 多数元素 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        int num = nums[0] , count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == num) count ++;
            else {
                if(count == 1) num = nums[i];
                else count --;
            }
        }
        return num;
    }
}
