package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = "simple";
        String questionNumber = "485";
        String targetQuestionName = "最大连续1的个数";
        String targetJavaMethodContent = "public int findMaxConsecutiveOnes(int[] nums)";
        String targetKotlinMethodContent = "fun findMaxConsecutiveOnes(nums: IntArray): Int";

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
