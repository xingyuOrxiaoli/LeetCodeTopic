package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "717";
        String targetQuestionName = "1比特与2比特字符射";
        String targetKotlinMethodContent = "fun findSecondMinimumValue(root: TreeNode?): Int";
        String targetJavaMethodContent = "public boolean isOneBitCharacter(int[] bits)";

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
