package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.DIFFICULTY;
        String questionNumber = "3474";
        String targetQuestionName = "字典序最小的生成字符串";
        String targetKotlinMethodContent = "fun generateString(str1: String, str2: String): String";
        String targetJavaMethodContent = "public String generateString(String str1, String str2)";

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
