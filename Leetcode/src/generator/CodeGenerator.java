package generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    private final String questionDir;

    private final String targetPackage;

    private final String targetInterfaceName;

    private final String targetJavaClassName;

    private final String targetKotlinClassName;

    private final String targetQuestionName;

    private final File targetDirectory;

    private final String targetJavaInterfaceContent;

    private final String targetJavaMethodContent;

    private final String targetKotlinMethodContent;

    public CodeGenerator(String target_dir,String questionDir ,String questionNumber,String targetQuestionName,String targetJavaMethodContent , String targetKotlinMethodContent) {
        this.targetPackage = "A"+questionNumber;
        String targetDir = target_dir + "\\" + targetPackage;
        this.questionDir = questionDir;
        this.targetInterfaceName = this.targetPackage + "Solution";
        this.targetJavaClassName = this.targetInterfaceName + "MethodV1";
        this.targetKotlinClassName = this.targetPackage;
        this.targetDirectory = new File(targetDir);
        this.targetQuestionName = targetQuestionName;
        this.targetJavaInterfaceContent = "    "+ targetJavaMethodContent +";";
        this.targetJavaMethodContent = "    @Override\n    "+targetJavaMethodContent+" {\n    }";
        this.targetKotlinMethodContent = "    override "+ targetKotlinMethodContent+" {\n        TODO()\n    }";
    }

    public CodeGenerator(String target_dir,String questionDir ,String questionNumber,String targetQuestionName) {
        this(target_dir,questionDir,questionNumber,targetQuestionName,"","");
    }

    public void generator() {

        if(!targetDirectory.exists()) {
            boolean isCreated = targetDirectory.mkdirs();
            if(isCreated) {
                System.out.println("创建目录成功" + targetDirectory.getName());
            }
        }

        generatorJavaQuestion();
        generateJavaInterface();
        generateJavaInterfaceImpl();
        generateKotlinInterface();


        showDirFile();
        showGenerateCodeFile();
    }


    /**
     * 生成题目Java类
     */
    private void generatorJavaQuestion() {
        File javaFile = new File(targetDirectory, targetQuestionName + ".java");
        if(javaFile.exists()) {
            return;
        }
        try(FileWriter fw = new FileWriter(javaFile)) {
            String content = "package "+questionDir+"."+ targetPackage +";\n\n" + "public class "+targetQuestionName+" {\n"
                    +"    public static void main(String[] args) {\n" +
                    "\n" +
                    "        "+targetInterfaceName+" solution = new "+targetJavaClassName+"();\n" +
                    "        solution.hammingDistance(4,1);\n" +
                    "    }"+
                    "}";
            fw.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 生成java接口
     */
    private void generateJavaInterface() {
        File javaFile = new File(targetDirectory, targetInterfaceName+".java");
        if(javaFile.exists()) {
            return;
        }
        try(FileWriter fw = new FileWriter(javaFile)) {
            String content = "package "+questionDir+"."+targetPackage+";\n" +
                    "\n" +
                    "public interface "+targetInterfaceName+" {\n" +
                    "\n" +
                    targetJavaInterfaceContent +
                    "\n" +
                    "}";
            fw.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成Java接口实现类
     */
    private void generateJavaInterfaceImpl() {
        File javaFile = new File(targetDirectory, targetJavaClassName+".java");
        if(javaFile.exists()) {
            return;
        }
        try(FileWriter fw = new FileWriter(javaFile)) {
            String content = "package "+questionDir+"."+targetPackage+";\n" +
                    "\n" +
                    "public class "+targetJavaClassName+"  implements "+targetInterfaceName+"{\n" +
                    "\n" +
                    targetJavaMethodContent +
                    "\n" +
                    "}";
            fw.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成kotlin实现类
     */
    private void generateKotlinInterface() {
        File javaFile = new File(targetDirectory, targetKotlinClassName+".kt");
        if(javaFile.exists()) {
            return;
        }
        try(FileWriter fw = new FileWriter(javaFile)) {
            String content = "package "+questionDir+"."+targetPackage+";\n" +
                    "\n" +
                    "class MethodVersion1 :  "+targetInterfaceName+"{\n" +
                    "\n" +
                    targetKotlinMethodContent +
                    "\n" +
                    "}";
            fw.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO  展示生成的类
     */
    private void showGenerateCodeFile() {

    }

    /**
     * TODO 展示当前目录有哪些文件
     */
    private void showDirFile() {

    }
}
