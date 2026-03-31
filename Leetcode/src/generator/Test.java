package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "628";
        String targetQuestionName = "三个数的最大乘积";
        String targetKotlinMethodContent = "fun maximumProduct(nums: IntArray): Int";
        String targetJavaMethodContent = "public int maximumProduct(int[] nums)";

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
