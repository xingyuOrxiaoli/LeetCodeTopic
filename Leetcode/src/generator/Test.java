package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.DIFFICULTY;
        String questionNumber = "2573";
        String targetQuestionName = "找出对应LCP矩阵的字符串";
        String targetKotlinMethodContent = "fun findTheString(lcp: Array<IntArray>): String";
        String targetJavaMethodContent = "public String findTheString(int[][] lcp)";

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
