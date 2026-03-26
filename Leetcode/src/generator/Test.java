package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "530";
        String targetQuestionName = "二叉搜索树的最小绝对差";
        String targetKotlinMethodContent = "fun getMinimumDifference(root: TreeNode?): Int";
        String targetJavaMethodContent = "public int getMinimumDifference(TreeNode root))";

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
