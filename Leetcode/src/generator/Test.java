package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.DIFFICULTY;
        String questionNumber = "329";
        String targetQuestionName = "矩阵中的最长递增路径";
        String targetKotlinMethodContent = "fun longestIncreasingPath(matrix: Array<IntArray>): Int";
        String targetJavaMethodContent = "public int longestIncreasingPath(int[][] matrix)";

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
