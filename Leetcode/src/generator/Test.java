package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = "simple";
        String questionNumber = "461";
        String targetQuestionName = "汉明距离";
        String targetJavaMethodContent = "public int hammingDistance(int x, int y)";
        String targetKotlinMethodContent = "fun hammingDistance(x: Int, y: Int): Int";

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
