package difficulty.A3480;

import java.util.*;

public class 删除一个冲突对后最大子数组数目 {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long res = 0 , max = 0;
        int[] first_min = new int[n + 1] , second_min = new int[n + 1] ;
        long[] addCount = new long[n + 1];
        Arrays.fill(first_min, Integer.MAX_VALUE);
        Arrays.fill(second_min, Integer.MAX_VALUE);
        for (int[] conflictingPair : conflictingPairs) {
            int x = Math.min(conflictingPair[0] , conflictingPair[1]) , y = Math.max(conflictingPair[0] , conflictingPair[1]);
            if(first_min[x] > y){
                second_min[x] = first_min[x];
                first_min[x] = y;
            }else if(second_min[x] > y) second_min[x] = y;
        }
        int first = n , second = n + 1;
        for(int i = n ; i > 0 ; i --){
            if(first_min[first] > first_min[i]){
                second = Math.min(second, first_min[first]);
                first = i;
            }else second = Math.min(second, first_min[i]);

            res += Math.min(first_min[first] , n + 1) - i;
            addCount[first] += Math.min(Math.min(second , second_min[first]) , n + 1) - Math.min(first_min[first] , n + 1);
        }

        for(int i = n ; i > 0 ; i --)  max = Math.max(max , addCount[i]);
        res += max;
        return res;
    }
}

class P1{

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long res = 0 , max = 0;
        int[] first_min = new int[n + 1] , second_min = new int[n + 1] ;

        Arrays.fill(first_min, n + 10);
        Arrays.fill(second_min, n + 10);
        for (int[] conflictingPair : conflictingPairs) {
            int x = Math.min(conflictingPair[0] , conflictingPair[1]) , y = Math.max(conflictingPair[0] , conflictingPair[1]);
            if(first_min[x] > y){
                second_min[x] = first_min[x];
                first_min[x] = y;
            }else if(second_min[x] > y) second_min[x] = y;
        }

        int first_index = n , second_index = first_index + 1;
        long[] addCount = new long[n + 1];
        for(int i  = n ; i > 0 ; i --){
            if(first_min[first_index] > first_min[i]){
                second_index = Math.min(second_index , first_min[first_index]);
                first_index = i;
            }else second_index = Math.min(second_index , first_min[i]);

            res += Math.min(first_min[first_index] , n + 1) - i;
            addCount[first_index] += Math.min(Math.min(second_index , second_min[first_index]) , n + 1) - Math.min(first_min[first_index] , n + 1);
        }
        for(int i = n ; i > 0 ; i --)  max = Math.max(max , addCount[i]);
        return res + max;
    }
}

