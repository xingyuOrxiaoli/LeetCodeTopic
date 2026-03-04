package simple.A1582;

public class 二进制矩阵中的特殊位置 {
    public static void main(String[] args) {

        int[][] mat = new int[][]{
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        A1582Solution solution = new A1582SolutionMethodV1();

        solution.numSpecial(mat);

    }
}
