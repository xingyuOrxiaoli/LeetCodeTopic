package medium.A33;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        int target = 4;
        int search = new 搜索旋转排序数组().search(nums,target);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        int mid = (l + r) >> 1;
        int lval = nums[l];
        int rval = nums[r];
        if(lval == target) return l;
        if(rval == target) return r;
        while (l <= r) {
            if(target == nums[mid]) {
                return mid;
            }
            if(target < nums[mid]) {
                if( (target > rval && nums[mid] > rval)  || (target < rval && nums[mid] < rval)) {
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }

            }else {
                if( (target >= lval && nums[mid] >=  lval) || (target < rval && nums[mid] < rval)){
                   l = mid + 1;
               }else {
                   r = mid - 1;
               }
            }
            mid = (l + r) >> 1;

        }
        return -1;
    }
}
