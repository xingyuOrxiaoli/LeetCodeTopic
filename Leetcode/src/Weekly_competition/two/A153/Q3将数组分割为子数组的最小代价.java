package Weekly_competition.two.A153;

public class Q3将数组分割为子数组的最小代价 {
    public static void main(String[] args) {
        int[] nums = {3,1,4 };
        int[] cost = {4,6,6};
        long l = new Q3将数组分割为子数组的最小代价().minimumCost(nums, cost, 1);
        System.out.println(l);
    }
    public long minimumCost(int[] nums, int[] cost, int k){
        int length = nums.length;
        long[] sn = new long[length + 1];
        long[] sc = new long[length + 1];
        sn[0] = nums[0];
        sc[0] = cost[0];
        for(int i = 1 ; i < length ; i++){
            sn[i] = sn[i -1] + nums[i];
            sc[i] = sc[i -1] + cost[i];
        }
        long res = 0;



        return res;
    }
}
