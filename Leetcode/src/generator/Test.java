package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "541";
        String targetQuestionName = "反转字符串II";
        String targetKotlinMethodContent = "fun reverseStr(s: String, k: Int): String";
        String targetJavaMethodContent = "public String reverseStr(String s, int k)";

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
