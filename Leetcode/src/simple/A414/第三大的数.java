package simple.A414;

import utils.ArrayUtils;

public class 第三大的数 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[5,2,2]");
        int i = new 第三大的数().thirdMax(nums);
        System.out.println(i);
    }
    public int thirdMax(int[] nums) {
        long n = nums.length , first = Long.MIN_VALUE , second = Long.MIN_VALUE , third = Long.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }else if(first > nums[i] && second < nums[i]){
                third = second;
                second = nums[i];
            }else if(second > nums[i] && third < nums[i]){
                third = nums[i];
            }
        }
        return (third == Long.MIN_VALUE) ? (int)first : (int)third;
    }
}
