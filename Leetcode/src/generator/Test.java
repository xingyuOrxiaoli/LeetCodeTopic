package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = "simple";
        String questionNumber = "463";
        String targetQuestionName = "岛屿的周长";
        String targetJavaMethodContent = "public int islandPerimeter(int[][] grid)";
        String targetKotlinMethodContent = "fun islandPerimeter(grid: Array<IntArray>): Int";

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
