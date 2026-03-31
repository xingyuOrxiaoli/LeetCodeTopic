package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "645";
        String targetQuestionName = "错误的集合";
        String targetKotlinMethodContent = "fun findErrorNums(nums: IntArray): IntArray";
        String targetJavaMethodContent = "public int[] findErrorNums(int[] nums)";

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
