package simple.A70;

public class 爬楼梯 {

    public static void main(String[] args) {
        int i = new 爬楼梯().climbStairs(2);
        System.out.println(i);
    }

    // 方法1 动态规划
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // 方法2 矩阵求幂  矩阵快速幂
    // 线性代数中 ： 一个矩阵的n次幂之后的矩阵之后每个数代表着n步到达当前位置的走法
    /**
     * n = 0 的时候的矩阵为
     *     1  1
     *     1  0
     *     上述矩阵表示
     */
    public int climbStairs2(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    // 方法三 优化矩阵
    public int climbStairs3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}
