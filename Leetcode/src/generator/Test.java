package generator;

public class Test {

    public static void main(String[] args) {
        CodeGenerator generator = new CodeGenerator(
                "D:\\note\\github\\LeetCodeTopic\\Leetcode\\src",
                "questionDir",
                "questionNumber",
                "targetQuestionName"
        );
        generator.generator();
    }

}
