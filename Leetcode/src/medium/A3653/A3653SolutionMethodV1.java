package medium.A3653;

public class A3653SolutionMethodV1  implements A3653Solution{

    @Override
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        for (int[] query : queries) {
            int t = query[3];
            for (int j = query[0]; j <= query[1]; j += query[2]) {
                long temp = (long) nums[j] * t;
                nums[j] = (int) (temp % mod);
            }
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}