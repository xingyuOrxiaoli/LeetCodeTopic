package medium.A334;

public class A334SolutionMethodV1  implements A334Solution{

    @Override
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = nums[0] , second = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(nums[i] > second){
                return true;
            } else if(nums[i] > first){
                second = nums[i];
            } else {
                second = first;
                first = nums[i];
            }
        }
        return false;
    }
}