package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "2946";
        String targetQuestionName = "循环移位后的矩阵相似检查";
        String targetKotlinMethodContent = "fun areSimilar(mat: Array<IntArray>, k: Int): Boolean";
        String targetJavaMethodContent = "public boolean areSimilar(int[][] mat, int k)";

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
