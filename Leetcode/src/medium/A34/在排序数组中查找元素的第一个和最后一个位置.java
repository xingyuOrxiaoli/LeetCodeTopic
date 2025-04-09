package medium.A34;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 0;
        int[] ints = new 在排序数组中查找元素的第一个和最后一个位置().searchRange2(nums,target);
        System.out.println(Arrays.toString(ints));
    }
    public int[] searchRange(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        if(r == -1) return new int[]{-1,-1};
        int start = -1 ;
        int end   = -1 ;

        int mid = (l + r) >> 1;
        while(l <  r){
            if(nums[mid] >  target){
                r = mid;
            }else{
                l = mid + 1 ;
            }
            mid = (l + r) >> 1;
        }
        end = l;
        l = 0 ;
        r = nums.length - 1;
        mid = (l + r + 1) >> 1;
        while(l <  r){
            if(nums[mid]  <  target){
                l = mid;
            }else{
                r = mid - 1 ;
            }
            mid = (l + r + 1) >> 1;
        }
        start = l;
        if(nums[end] != target) {
            end --;
        }
        if(nums[start] != target) {
            start ++;
        }

        if(start >  end) return new int[]{-1,-1};
        return new int[]{start,end};
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums.length == 0) return res;
        int l = 0 , r = nums.length -1 , mid = (l + r + 1) >> 1;
        // 第一个
        while(l < r){
            if(nums[mid] < target) l = mid;
            else r = mid - 1;
            mid = (l + r + 1) >> 1;
        }
        if(nums[l] != target) l ++;
        res[0] = l;
        // 最后一个
        l = 0 ;
        r = nums.length -1 ;
        mid = (r + l ) >> 1;
        while(l < r){
            if(nums[mid] > target) r = mid;
            else l = mid + 1;
            mid = (r + l ) >> 1;
        }

        if(nums[l] != target) l -- ;
        res[1] = l;
        if(res[0] > res[1]) return new int[]{-1,-1};
        return res ;
    }
}
