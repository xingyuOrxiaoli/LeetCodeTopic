package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "671";
        String targetQuestionName = "二叉树中第二小的节点";
        String targetKotlinMethodContent = "fun findSecondMinimumValue(root: TreeNode?): Int";
        String targetJavaMethodContent = "public int findSecondMinimumValue(TreeNode root)";

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
