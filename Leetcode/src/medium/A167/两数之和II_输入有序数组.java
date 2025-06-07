package medium.A167;

import utils.ArrayUtils;

import java.util.Arrays;

public class 两数之和II_输入有序数组 {
    public static void main(String[] args) {
        int[] numbers = ArrayUtils.createArrayOne("[2,7,11,15]");
        int[] res = new 两数之和II_输入有序数组().twoSum1(numbers, 9);
        System.out.println(Arrays.toString(res));
    }
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int j = target - numbers[i];
            if(j <= numbers[i]) continue;
            int y = Arrays.binarySearch(numbers, j);
            if(y == i && numbers[y + 1] == numbers[y]) y ++;
            if(y > i){
                res[0] = i + 1;
                res[1] = y + 1;
                break;
            }
        }

        return res;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if(numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }else if(numbers[left] + numbers[right] < target){
                left ++;
            }else {
                right -- ;
            }
        }
        return res;
    }

}
