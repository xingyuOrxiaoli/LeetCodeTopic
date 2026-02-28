package simple.A338;

public class A338SolutionMethodV1 implements A338Solution {
    @Override
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}
