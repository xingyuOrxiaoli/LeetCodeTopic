package simple.A26;

public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int i = new 删除有序数组中的重复项().removeDuplicates(arr);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int sum = 0;
        int length = nums.length;
        int temp = nums[sum];
        for(int i = 1 ; i < length ; i++){
            if(nums[i] == temp) continue;
            temp = nums[i];
            nums[++sum] = nums[i];
        }
        return sum + 1;
    }
}
