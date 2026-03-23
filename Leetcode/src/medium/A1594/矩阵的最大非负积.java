package medium.A1594;

public class 矩阵的最大非负积 {
    public static void main(String[] args) {

        A1594Solution solution = new A1594SolutionMethodV1();
        int[][] grid = new int[][] {
                {-1,-2,-3},
                {-2,-3,-3},
                {-3,-3,-2}
        };
        System.out.println(solution.maxProductPath(grid));
    }}