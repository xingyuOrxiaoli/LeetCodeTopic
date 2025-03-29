package Weekly_competition.two.A153;

public class Q1字符串的反转度 {
    public static void main(String[] args) {
        int i = new Q1字符串的反转度().reverseDegree("abc");
        System.out.println(i);
    }
    public int reverseDegree(String s) {
        int res = 0 ;
        int length = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < length; i++) {
            res += ('z' - ch[i] + 1) * (i+ 1);
        }
        return res;
    }
}
