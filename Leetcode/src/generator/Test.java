package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "605";
        String targetQuestionName = "种花问题";
        String targetKotlinMethodContent = "fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean";
        String targetJavaMethodContent = "public boolean canPlaceFlowers(int[] flowerbed, int n)";

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
