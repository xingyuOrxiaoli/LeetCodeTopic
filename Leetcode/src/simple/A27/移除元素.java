package simple.A27;

public class 移除元素 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int i = new 移除元素().removeElement(nums, 3);
        System.out.println(i);
    }
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if(nums[i] != val) {
                nums[res++] = nums[i];
            }
        }

        return res;
    }
}
