package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "2840";
        String targetQuestionName = "判断通过操作能否让字符串相等II";
        String targetKotlinMethodContent = "fun checkStrings(s1: String, s2: String): Boolean";
        String targetJavaMethodContent = "public boolean checkStrings(String s1, String s2)";

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
