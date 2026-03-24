package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "2906";
        String targetQuestionName = "构造乘积矩阵";
        String targetKotlinMethodContent = "fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray>";
        String targetJavaMethodContent = " public int[][] constructProductMatrix(int[][] grid)";

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
