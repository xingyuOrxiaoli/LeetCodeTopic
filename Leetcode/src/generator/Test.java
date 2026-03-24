package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.MEDIUM;
        String questionNumber = "506";
        String targetQuestionName = "相对名次";
        String targetKotlinMethodContent = "fun findRelativeRanks(score: IntArray): Array<String>";
        String targetJavaMethodContent = "public String[] findRelativeRanks(int[] score)";

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
