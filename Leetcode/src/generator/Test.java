package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "617";
        String targetQuestionName = "合并二叉树";
        String targetKotlinMethodContent = "fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode?";
        String targetJavaMethodContent = "public TreeNode mergeTrees(TreeNode root1, TreeNode root2)";

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
