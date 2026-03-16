package medium.A1878;

public class 矩阵中最大的三个菱形和 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        A1878Solution solution = new A1878SolutionMethodV1();
        solution.getBiggestThree(grid);
    }

}
