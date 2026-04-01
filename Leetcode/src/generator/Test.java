package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "334";
        String targetQuestionName = "递增的三元子序列";
        String targetKotlinMethodContent = "fun findSecondMinimumValue(root: TreeNode?): Int";
        String targetJavaMethodContent = "public boolean increasingTriplet(int[] nums)";

        CodeGenerator generator = new CodeGenerator(
                "D:\\note\\github\\LeetCodeTopic\\Leetcode\\src\\"+questionDir,
                questionDir,
                questionNumber,
                targetQuestionName,
                targetJavaMethodContent,
                targetKotlinMethodContent
        );
        generator.generator(true,false);
    }

}
