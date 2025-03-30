package Weekly_competition.one.A443;

public class Q1到达每个位置的最小费用 {
    public static void main(String[] args) {
        int[] cost = new int[]{5,3,4,1,3,2};
        int[] ints = new Q1到达每个位置的最小费用().minCosts(cost);
        System.out.println(ints);
    }
    public int[] minCosts(int[] cost) {
        int length = cost.length;
        int[] res = new int[length];
        int min = cost[0];
        res[0] = min;
        for (int i = 1; i < length; i++) {
            min = Math.min(min, cost[i]);
            res[i] = min;
        }
        return res;
    }
}
