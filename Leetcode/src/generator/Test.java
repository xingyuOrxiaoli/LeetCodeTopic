package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = "simple";
        String questionNumber = "482";
        String targetQuestionName = "密钥格式化";
        String targetJavaMethodContent = "public String licenseKeyFormatting(String s, int k)";
        String targetKotlinMethodContent = "fun licenseKeyFormatting(s: String, k: Int): String";

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
