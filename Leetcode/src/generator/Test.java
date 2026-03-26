package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "521";
        String targetQuestionName = "最长特殊序列I";
        String targetKotlinMethodContent = "fun findLUSlength(a: String, b: String): Int";
        String targetJavaMethodContent = "public int findLUSlength(String a, String b)";

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
