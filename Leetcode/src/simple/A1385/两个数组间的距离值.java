package simple.A1385;

import java.util.Arrays;

public class 两个数组间的距离值 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        int i = Arrays.binarySearch(arr, 3);
        System.out.println(i);
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0 , n = arr1.length , m = arr2.length;
        for(int i = 0 ; i <  n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(Math.abs(arr1[i] - arr2[j])  <= d) break;
                if(j == m-1) res++;
            }
        }
        return res;
    }
    // 二分
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int res = 0 ;
        Arrays.sort(arr2);
        for (int value :arr1){
            int index = Arrays.binarySearch(arr2, value - d);
            if(index < 0) index = ~index ; // -index - 1
            if(index == arr2.length || arr2[index] > value + d) res++;
        }

        return res;
    }
}
