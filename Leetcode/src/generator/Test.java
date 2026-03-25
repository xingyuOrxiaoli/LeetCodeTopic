package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "507";
        String targetQuestionName = "完美数";
        String targetKotlinMethodContent = "fun checkPerfectNumber(num: Int): Boolean";
        String targetJavaMethodContent = "public boolean checkPerfectNumber(int num)";

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
