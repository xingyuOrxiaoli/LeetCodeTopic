package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "3546";
        String targetQuestionName = "等和矩阵分割I";
        String targetKotlinMethodContent = "fun canPartitionGrid(grid: Array<IntArray>): Boolean";
        String targetJavaMethodContent = "public boolean canPartitionGrid(int[][] grid)";

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
