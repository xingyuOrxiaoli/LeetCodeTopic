package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = "simple";
        String questionNumber = "1886";
        String targetQuestionName = "判断矩阵经轮转后是否一致";
        String targetJavaMethodContent = "public boolean findRotation(int[][] mat, int[][] target)";
        String targetKotlinMethodContent = "fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean";

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
