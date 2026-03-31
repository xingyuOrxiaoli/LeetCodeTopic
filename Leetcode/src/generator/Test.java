package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "657";
        String targetQuestionName = "机器人能否返回原点";
        String targetKotlinMethodContent = "fun judgeCircle(moves: String): Boolean";
        String targetJavaMethodContent = "public boolean judgeCircle(String moves)";

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
