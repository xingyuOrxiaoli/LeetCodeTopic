package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "492";
        String targetQuestionName = "构造矩形";
        String targetJavaMethodContent = "public int[] constructRectangle(int area)";
        String targetKotlinMethodContent = "fun constructRectangle(area: Int): IntArray";

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
