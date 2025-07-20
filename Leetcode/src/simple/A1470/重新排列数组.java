package simple.A1470;

public class 重新排列数组 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n << 1];

        for(int i = 0 , k = 0 ,j = n ; i < n ; i ++ , j ++ ,k +=2){
            res[k] = nums[i];
            res[k + 1] = nums[j];
        }

        return res;
    }
}
