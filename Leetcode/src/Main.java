import java.io.File;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[] str = new String[]{"3488. 距离最小相等元素查询", "28. 找出字符串中第一个匹配项的下标", "27. 移除元素", "2360. 图中的最长环", "11. 盛最多水的容器", "23. 合并 K 个升序链表", "7. 整数反转", "6. Z 字形变换", "5. 最长回文子串", "4. 寻找两个正序数组的中位数", "1. 两数之和", "26. 删除有序数组中的重复项", "25. K 个一组翻转链表", "2716. 最小化字符串长度", "24. 两两交换链表中的节点", "2712. 使所有字符相等的最小成本", "22. 括号生成", "21. 合并两个有序链表", "2829. k-avoiding 数组的最小总和", "20. 有效的括号", "19. 删除链表的倒数第 N 个结点", "2711. 对角线上不同值的数量差", "18. 四数之和", "17. 电话号码的字母组合", "2255. 统计是给定字符串前缀的字符串数目", "16. 最接近的三数之和", "15. 三数之和", "2116. 判断一个括号字符串是否有效", "14. 最长公共前缀", "13. 罗马数字转整数", "2643. 一最多的行", "12. 整数转罗马数字", "2680. 最大或值", "10. 正则表达式匹配", "9. 回文数", "2612. 最少翻转操作数", "8. 字符串转换整数 (atoi)", "2610. 转换二维数组", "2614. 对角线上的质数", "2272. 最大波动的子字符串", "3487. 删除后的最大子数组元素和", "3. 无重复字符的最长子串", "3110. 字符串的分数", "2. 两数相加", "3340. 检查平衡字符串" };

    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        int simple     = 0 ;
        int medium     = 0 ;
        int difficulty = 0 ;
        int sum        = 0 ;
        File file = new File("src");
        List<Integer> list = new ArrayList<>();
        for (File listFile : file.listFiles()) {
            if(listFile.isDirectory()) {
                int temp = 0;
                for (File listedFile : listFile.listFiles()) {
                    if (listedFile.isDirectory()){
                        temp ++ ;
                        list = getNoTopic(listedFile,list);
                    }
                }
                sum += temp;
                switch (listFile.getName()){
                    case "simple": simple = temp;break;
                    case "medium": medium = temp;break;
                    case "difficulty": difficulty = temp;break;
                }
            }
        }
        for(int i = 0 ; i < str.length ; i++){
            if(!list.contains(i)){
                System.out.println(str[i]);
            }
        }

        System.out.println(list);
        System.out.println("总的题目数量 = " + sum);
        System.out.println("简单难度题目 = " + simple);
        System.out.println("中等难度题目 = " + medium);
        System.out.println("困难难度题目 = " + difficulty);

        double[] dx = new double[]{5,10,15,20,30,40,50,60,70,90,120};
        double[] dy = new double[]{6,10,10,13,16,17,19,23,25,29,46};
        double x = 0 , y= 0 , xy = 0 , xx =  0 , yy = 0 ;
        for(int i = 0 ; i < dx.length ; i++) x += dx[i];
        for(int i = 0 ; i < dy.length ; i++) y += dy[i];
        for(int i = 0 ; i < dx.length ; i++) xx += (dx[i] * dx[i]);
        xx  = xx * 11 - x * x;
        for(int i = 0 ; i < dx.length ; i++) xy += (dx[i] * dy[i]);
        for(int i = 0 ; i < dx.length ; i++) yy += (dy[i] * dy[i]);
        yy  = yy * 11 - y * y;
        xy  = xy * 11 - x * y;
        System.out.println(x);
        System.out.println(xx);
        System.out.println(xy);
        System.out.println(yy);
        System.out.println(y);
        System.out.println(xy / xx );
        System.out.println((214 * xx  - xy) / (xx * 11));
        System.out.println((214 - (510 * xy / xx) )/ 11);
        System.out.println(xy / (Math.sqrt(yy * xx)));
        System.out.println((xy * xy) / (11 * xx)); // SR
        System.out.println((yy / 11) - ((xy * xy) / (11 * xx)) ); // SE
        System.out.println( (9 * ((xy * xy) / (11 * xx))) / ((yy / 11) - ((xy * xy) / (11 * xx))));
        System.out.println(5.344432882414153 + 0.30433576135969476 * 50);
        System.out.println(20.56122095039889 - 2.26 *(Math.sqrt(1 + 1 / 11 + ((11 * (50 - x / 11)*(50 - x / 11)) / xx))));
        System.out.println(20.56122095039889 + 2.26 *(Math.sqrt(1 + 1 / 11 + ((11 * (50 - x / 11)*(50 - x / 11)) / xx))));


        System.out.println(" ======================= ");
        double t1 = 24.7 + 24.3 + 21.6 + 19.3 + 20.3;
        double t2 = 30.8 + 19.0 + 18.8 + 29.7;
        double t3 = 17.9 + 30.4 + 34.9 + 34.1 + 15.9 ;
        double t4 = 23.1 + 33.0 + 23.0 + 26.4 + 18.1  + 25.1;

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t1 / 5);
        System.out.println(t2 / 4);
        System.out.println(t3 / 5);
        System.out.println(t4 / 6);

        System.out.println();
    }
    private static List<Integer> getNoTopic(File file , List<Integer> list){
        list = new ArrayList<>();
        for (File file1 : file.listFiles()) {
            // System.out.println(file1.getName().split(".java")[0]);
            for (int i = 0; i < str.length; i++) {
//                System.out.println(file1.getName().split(".java")[0]);
                if (str[i].contains(file1.getName().split(".java")[0])) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}