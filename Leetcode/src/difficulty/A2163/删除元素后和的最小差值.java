package difficulty.A2163;

import utils.ArrayUtils;

import java.util.PriorityQueue;

public class 删除元素后和的最小差值 {
    public static void main(String[] args) {
        long res = new 删除元素后和的最小差值().minimumDifference(ArrayUtils.createArrayOne("[7,9,5,8,1,3]"));
        System.out.println(res);
    }
    public long minimumDifference(int[] nums) {
        int m = nums.length , n = m / 3;
        long res = Long.MAX_VALUE , part2 = 0 , sum = 0;
        PriorityQueue<Integer> queueMax = new PriorityQueue<>((a , b)-> b - a) ,queueMin = new PriorityQueue<>();
        long[] part1 = new long[ n + 1] ;
        for(int i = 0 ; i < n ; i ++){
            sum += nums[i];
            queueMax.add(nums[i]);
        }
        part1[0] = sum;
        for(int i = n ; i < (n << 1) ; i ++){
            sum += nums[i];
            queueMax.add(nums[i]);
            sum -= queueMax.poll();
            part1[i - n + 1] = sum;
        }
        for(int i = (n << 1) ; i < m ; i ++){
            part2 += nums[i];
            queueMin.add(nums[i]);
        }
        res = part1[n] - part2;
        for(int i = (n << 1) - 1 ; i >= n  ; i --){
            part2 += nums[i];
            queueMin.add(nums[i]);
            part2 -= queueMin.poll();
            res = Math.min(res, part1[i - n] - part2);
        }
        return res;
    }
}
