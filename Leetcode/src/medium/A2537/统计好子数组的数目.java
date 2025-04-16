package medium.A2537;


import java.util.HashMap;
import java.util.Map;

public class 统计好子数组的数目 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        long l = new 统计好子数组的数目().countGood(nums, 10);
        l = new 统计好子数组的数目().countGood_1(nums, 10);
        System.out.println(l);
    }
    public long countGood(int[] nums, int k) {
        int n = nums.length , sum = 0, j = -1;
        long res = 0 ;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i ++ ){
            while(sum < k && j + 1 < n ){
                j ++ ;
                sum += map.getOrDefault(nums[j], 0);
                map.put(nums[j] , map.getOrDefault(nums[j], 0) + 1);
            }
            if(sum >= k )  res += n - j;
            map.put(nums[i] , map.get(nums[i]) - 1);
            sum -= map.get(nums[i]);
        }
        return res;
    }
    // 练习 1
    public long countGood_1(int[] nums, int k) {
        int n = nums.length , sum = 0 , j = 0 ;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int  i = 0 ; i <  n ; i++){
            while(sum < k &&  j < n){
                sum += map.getOrDefault(nums[j] , 0 );
                map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);
                j ++ ;
            }
            if(sum >= k)  res += n - j + 1;
            map.put(nums[i] , map.get(nums[i]) - 1);
            sum -= map.get(nums[i]);
        }
        return res ;
    }
}
