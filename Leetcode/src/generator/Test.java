package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "572";
        String targetQuestionName = "另一棵树的子树";
        String targetKotlinMethodContent = "fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean";
        String targetJavaMethodContent = "public boolean isSubtree(TreeNode root, TreeNode subRoot)";

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
