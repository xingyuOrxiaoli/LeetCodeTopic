package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "566";
        String targetQuestionName = "重塑矩阵";
        String targetKotlinMethodContent = "fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray>";
        String targetJavaMethodContent = "public int[][] matrixReshape(int[][] mat, int r, int c)";

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
