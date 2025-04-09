package medium.A33;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        int target = 0;
        int search = new 搜索旋转排序数组().search2(nums,target);
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

    public int search2(int[] nums, int target) {
        int res = -1 ,end = nums.length - 1;
        if(target < nums[0] && target > nums[end])  return  -1;
        int l = 0 , r = end, mid = (l + r) >> 1;
        while(l <= r){
            if(nums[mid] == target){
                res = mid;
                break;
            }
            // 向右边移动的情况
            // 情况1 ： target >= nums[0]   && target > nums[mid] && nums[mid] >= nums[0]    mid在大的区间 但是target更大
            // 情况2 ： target <  nums[0]   && target < nums[mid] && nums[mid] >= nums[0]    mid在大的区间 但target 在小区间
            // 情况3 ： target <  nums[0]   && target > nums[mid] && nums[mid] <  nums[0]    mid在小区间  并且 target比nums[mid]更大 target也在小区间内
            // 情况4 ： 正序数列
            // 情况5 ： 逆序数列
            if((target >= nums[0]   && target > nums[mid] && nums[mid] >= nums[0]) || (target <  nums[0]   && target < nums[mid] && nums[mid] >= nums[0]) || (target <  nums[0]   && target > nums[mid] && nums[mid] <  nums[0])) {
                l = mid + 1;
            }
            // 向左边移动的情况
            // 情况1 ： target >= nums[0]   && target < nums[mid] && nums[mid] >= nums[0]    mid在大区间 并且target也在大区间 并且nums[mid] > target
            // 情况2 ： target >= nums[0]   && target > nums[mid] && nums[mid] <  nums[0]    mid在小区间 并且target在大区间
            // 情况3 ： target <  nums[0]   && target < nums[mid] && nums[mid] <  nums[0]    mid在小区间 并且target也在小区间 并且nums[mid] > target
            // 情况4 ： 正序数列
            // 情况5 ： 逆序数列
            else if((target >= nums[0]   && target < nums[mid] && nums[mid] >= nums[0]) || (target >= nums[0]   && target > nums[mid] && nums[mid] <  nums[0]) || (target <  nums[0]   && target < nums[mid] && nums[mid] <  nums[0])) {
                r = mid - 1;
            }
            mid = (l + r) >> 1;
        }

        return res;
    }
}
