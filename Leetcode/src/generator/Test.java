package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "637";
        String targetQuestionName = "二叉树的层平均值";
        String targetKotlinMethodContent = "fun averageOfLevels(root: TreeNode?): DoubleArray";
        String targetJavaMethodContent = "public List<Double> averageOfLevels(TreeNode root)";

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
