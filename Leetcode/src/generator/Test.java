package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "501";
        String targetQuestionName = "二叉搜索树中的众数";
        String targetKotlinMethodContent = "fun findMode(root: TreeNode?): IntArray";
        String targetJavaMethodContent = "public int[] findMode(TreeNode root)";

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
