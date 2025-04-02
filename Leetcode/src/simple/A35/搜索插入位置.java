package simple.A35;

public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        int i = new 搜索插入位置().searchInsert(nums, target);
        System.out.println(i);
    }
    public int searchInsert(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {return mid;}
            if (nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
