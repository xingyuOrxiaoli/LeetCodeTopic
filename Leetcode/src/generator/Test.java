package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "2839";
        String targetQuestionName = "判断通过操作能否让字符串相等I";
        String targetKotlinMethodContent = "fun canBeEqual(s1: String, s2: String): Boolean";
        String targetJavaMethodContent = " public boolean canBeEqual(String s1, String s2)";

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
