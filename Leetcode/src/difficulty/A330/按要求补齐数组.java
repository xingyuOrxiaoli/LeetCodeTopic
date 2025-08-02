package difficulty.A330;

public class 按要求补齐数组 {
    public int minPatches(int[] nums, int n) {
        int res = 0 ,index = 0  , m = nums.length;
        long cur = 1;
        while(cur <= n){
            if(index < m && nums[index] <= cur){
                cur += nums[index];
                index ++;
            }else {
                res ++;
                cur <<= 1;
            }
        }
        return res;
    }
}
class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}