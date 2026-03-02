package medium.A1536;


public class A1536SolutionMethodV1 implements A1536Solution {
    @Override
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] != 0 || j == 0) {
                    zeros[i] = n - 1 - j;
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curMin = n - i - 1;
            int preVal = zeros[i];
            if (preVal >= curMin) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                res++;
                int curVal = zeros[j];
                zeros[j] = preVal;
                if (curVal >= curMin) {
                    break;
                } else if (j == n - 1) {
                    return -1;
                }
                preVal = curVal;
            }
        }
        return res;
    }
}
