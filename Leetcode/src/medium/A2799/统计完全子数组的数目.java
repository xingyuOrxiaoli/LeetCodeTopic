package medium.A2799;

import java.util.Arrays;

public class 统计完全子数组的数目 {

    public static void main(String[] args) {
        int[] nums = {
                1917,1917,608,608,1313,751,558,1561,608
        };
        int i = new 统计完全子数组的数目().countCompleteSubarrays_2(nums);
        System.out.println(i);
    }

    // 暴力解
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length , count1 = 0 ,count2 = 0;
        boolean[] st1 = new boolean[2001], st2 = new boolean[2001];
        for(int i = 0 ; i < n ; i++)
            if (!st1[nums[i]]) {
                st1[nums[i]] = true;
                count1 ++;
            }
        int res = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(!st2[nums[j]]) count2++;
                st2[nums[j]] = true;
                if(count1 == count2){
                    res ++;
                }
            }
            count2 = 0;
            Arrays.fill(st2,false);
        }
        return res;
    }
    // 暴力解的优化
    public int countCompleteSubarrays_2(int[] nums) {
        int res = 0 , n = nums.length , count1 = 0 ,count2 = 0 ;
        boolean[] st = new boolean[2001];
        for(int i = 0 ; i < n ; i++)
            if(!st[nums[i]]){
                st[nums[i]] = true;
                count1 ++;
            }
        for(int i = 0 ; i < n - count1 + 1; i++){
            Arrays.fill(st,false);
            count2 = 0 ;
            for(int j = i ; j < n ; j++){
                if(!st[nums[j]]){
                    count2 ++;
                    st[nums[j]] = true;
                }
                if(count1 == count2){
                    res += n - j;
                    break;
                }
            }
            if(count1 < count2) break;
        }
        return res;
    }
}
