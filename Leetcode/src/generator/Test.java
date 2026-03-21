package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = "simple";
        String questionNumber = "3643";
        String targetQuestionName = "垂直翻转子矩阵";
        String targetJavaMethodContent = "public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k)";
        String targetKotlinMethodContent = "fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray>";

        CodeGenerator generator = new CodeGenerator(
                "D:\\note\\github\\LeetCodeTopic\\Leetcode\\src\\"+questionDir,
                questionDir,
                questionNumber,
                targetQuestionName,
                targetJavaMethodContent,
                targetKotlinMethodContent
        );
        generator.generator();
    }

}
