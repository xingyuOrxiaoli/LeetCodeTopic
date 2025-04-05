package difficulty.A41;

public class 缺失的第一个正数 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        int i = new 缺失的第一个正数().firstMissingPositive1(nums);
        nums = new int[]{3,4,-1,1};
        i = new 缺失的第一个正数().firstMissingPositive2(nums);
        System.out.println(i);
    }
    // 方法1 打标签
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0 ){
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(nums[i]);
            if(temp <= n){
                nums[temp - 1] = -Math.abs(nums[temp - 1] );
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0 ){
                return i + 1;
            }
        }
        return n + 1;
    }

    // 方法2 打标签
    public int firstMissingPositive2(int[] nums) {
       int n = nums.length;
       for (int i = 0; i < n; i++) {
           while(nums[i] > 0 && nums[i] <= n && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
               swap(nums,i,nums[i] - 1);
           }
       }
       for(int i = 0; i < n; i++){
           if(nums[i] != i + 1){
               return i + 1;
           }
       }
       return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[i] ^ nums[j];
    }
}
