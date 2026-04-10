package generator;

public class Test {

    public static void main(String[] args) {
        String questionDir = QuestionDir.SIMPLE;
        String questionNumber = "728";
        String targetQuestionName = "自除数";
        String targetKotlinMethodContent = "fun findSecondMinimumValue(root: TreeNode?): Int";
        String targetJavaMethodContent = "public List<Integer> selfDividingNumbers(int left, int right)";

        CodeGenerator generator = new CodeGenerator(
                "D:\\note\\github\\LeetCodeTopic\\Leetcode\\src\\"+questionDir,
                questionDir,
                questionNumber,
                targetQuestionName,
                targetJavaMethodContent,
                targetKotlinMethodContent
        );
        generator.generator(true,false);
    }

}
