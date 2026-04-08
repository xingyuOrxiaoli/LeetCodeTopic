package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "703";
        String targetQuestionName = "A703.数据流中的第K大元素";
        String targetKotlinMethodContent = "fun findSecondMinimumValue(root: TreeNode?): Int";
        String targetJavaMethodContent = "public int xorAfterQueries(int[] nums, int[][] queries)";

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
