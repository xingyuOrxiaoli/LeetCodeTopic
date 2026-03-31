package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "331";
        String targetQuestionName = "验证二叉树的前序序列化";
        String targetKotlinMethodContent = "fun isValidSerialization(preorder: String): Boolean";
        String targetJavaMethodContent = "public boolean isValidSerialization(String preorder)";

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
