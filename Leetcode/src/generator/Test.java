package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "653";
        String targetQuestionName = "两数之和IV_输入二叉搜索树";
        String targetKotlinMethodContent = "fun findTarget(root: TreeNode?, k: Int): Boolean";
        String targetJavaMethodContent = "public boolean findTarget(TreeNode root, int k)";

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
