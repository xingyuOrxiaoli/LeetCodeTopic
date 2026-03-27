package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "543";
        String targetQuestionName = "二叉树的直径";
        String targetKotlinMethodContent = "fun diameterOfBinaryTree(root: TreeNode?): Int";
        String targetJavaMethodContent = "public int diameterOfBinaryTree(TreeNode root)";

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
