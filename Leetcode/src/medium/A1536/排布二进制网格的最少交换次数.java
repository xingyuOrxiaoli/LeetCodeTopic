package medium.A1536;

public class 排布二进制网格的最少交换次数 {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0, 0}, {0, 1}};
        A1536Solution solution = new A1536SolutionMethodV1();
        solution.minSwaps(grid);

        grid = new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}};
        solution = new MethodVersion1();
        solution.minSwaps(grid);

    }
}
