package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "1594";
        String targetQuestionName = "矩阵的最大非负积";
        String targetJavaMethodContent = "public int maxProductPath(int[][] grid)";
        String targetKotlinMethodContent = "fun maxProductPath(grid: Array<IntArray>): Int";

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
