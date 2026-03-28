package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "559";
        String targetQuestionName = "N叉树的最大深度";
        String targetKotlinMethodContent = "fun maxDepth(root: Node?): Int";
        String targetJavaMethodContent = "public int maxDepth(Node root)";

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
