package medium.A189;

import utils.ArrayUtils;

public class 轮转数组 {
    public static void main(String[] args) {
        int[] nums  = ArrayUtils.createArrayOne("[-1,-100,3,99]");
        new  轮转数组().rotate(nums,2);
    }


    public void rotate(int[] nums, int k) {
        int cur = nums[0] , n = nums.length, index = k % n , sum = 0;
        boolean[] visited = new boolean[n];
        while(sum != n){
            int temp = nums[index];
            nums[index] = cur;
            visited[index] = true;
            sum ++;

            index = (index + k) % n;
            if(visited[index] && sum < n){
                for(int i = 0 ; i < n; i++){
                    if(!visited[(i + k) % n]){
                        index = (i + k) % n;
                        cur = nums[i];
                        break;
                    }
                }
            }else cur = temp;
        }
    }
}
