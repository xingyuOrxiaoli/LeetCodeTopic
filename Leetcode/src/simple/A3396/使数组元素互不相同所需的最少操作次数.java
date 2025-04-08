package simple.A3396;

public class 使数组元素互不相同所需的最少操作次数 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,2,3,3,5,7};
        int i = new 使数组元素互不相同所需的最少操作次数().minimumOperations(nums);
        System.out.println(i);
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length ;
        if(n == 0 || n ==  1) return 0;
        int[] st = new int[101];
        int sum = 0 ,start = 0;
        for(int i = 0 ;i < n ; i++){
            if(st[nums[i]] == 0) sum ++;
            st[nums[i]]++;
        }
        int res = 0 ;
        while(sum != n - start){
            res ++;
            if(start > n - 3) break;
            for(int i = 0 ; i < 3 ;i ++){
                if(st[nums[start]] == 1){
                    sum -- ;
                }
                st[nums[start ++ ]]--;
            }
        }
        return res;
    }
}
