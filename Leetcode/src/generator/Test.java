package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "561";
        String targetQuestionName = "数组拆分";
        String targetKotlinMethodContent = "fun arrayPairSum(nums: IntArray): Int";
        String targetJavaMethodContent = "public int arrayPairSum(int[] nums)";

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
