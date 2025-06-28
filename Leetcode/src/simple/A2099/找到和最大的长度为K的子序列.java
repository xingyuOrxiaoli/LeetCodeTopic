package simple.A2099;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class 找到和最大的长度为K的子序列 {
    public static void main(String[] args) {
        int[] arrayOne = ArrayUtils.createArrayOne("[-16,-13,8,16,35,-17,30,-8,34,-2,-29,-35,15,13,-30,-34,6,15,28,-23,34,28,-24,15,-17,10,31,32,-3,-36,19,31,-5,-21,-33,-18,-23,-37,-15,12,-28,-40,1,38,38,-38,33,-35,-28,-40,4,-15,-29,-33,-18,-9,-29,20,1,36,-8,23,-34,16,-7,13,39,38,7,-7,-10,30,9,26,27,-37,-18,-25,14,-36,23,28,-15,35,-9,1]");
        int[] ints = new 找到和最大的长度为K的子序列().maxSubsequence2(arrayOne, 8);
        System.out.println(Arrays.toString(ints));
    }
    // sort 排序 + 二维数组
    public int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k] ;
        int n = nums.length;
        int[][] numbers = new int[n][2];
        for (int i = 0; i < n; i++) {
            numbers[i][0] = nums[i];
            numbers[i][1] = i;
        }
        Arrays.sort(numbers, (number1 ,number2) -> Integer.compare(number2[0] , number1[0]));

        Arrays.sort(numbers,0 , k,(number1 ,number2) -> Integer.compare(number1[1] , number2[1]));
        for (int i = 0 ; i < k; i++) {
            res[i] = numbers[i][0];
        }

        return res;
    }

    // sort 排序 + 一位数组
    public int[] maxSubsequence2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k] , numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers);
        int leftCount = 1 , left = n - k  , index = left - 1;
//        while (index > -1 && numbers[index] == numbers[left]){
//            leftCount ++;
//            index --;
//        }
        index = left + 1;
        while(index < n && numbers[index] == numbers[left]){
            leftCount ++;
            index ++;
        }
        for(int i = 0  , j = 0 ; i < n &&  j < k ; i ++ ){
            if(nums[i] > numbers[left] || (numbers[left] == nums[i] && leftCount != 0)){
                if(numbers[left] == nums[i]) leftCount --;
                res[j ++] = nums[i];
            }
        }
        return res;
    }

}