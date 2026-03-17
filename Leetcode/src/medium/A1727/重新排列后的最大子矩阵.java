package medium.A1727;

public class 重新排列后的最大子矩阵 {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 1, 0},
                {1, 0, 1}
        };

        A1727Solution solution = new A1727SolutionMethodV2();
        solution.largestSubmatrix(matrix);

    }
}
