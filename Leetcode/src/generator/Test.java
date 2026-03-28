package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "551";
        String targetQuestionName = "学生出勤记录I";
        String targetKotlinMethodContent = "fun checkRecord(s: String): Boolean";
        String targetJavaMethodContent = "public boolean checkRecord(String s)";

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
