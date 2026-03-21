package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = "simple";
        String questionNumber = "476";
        String targetQuestionName = "数字的补数";
        String targetJavaMethodContent = "public int findComplement(int num)";
        String targetKotlinMethodContent = "fun findComplement(num: Int): Int";

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
