package simple.A3110;

public class 字符串的分数 {
    public static void main(String[] args) {
        int i = new 字符串的分数().scoreOfString("hello");
        System.out.println(i);
    }
    public int scoreOfString(String s) {
        int res  = 0 ;
        int length = s.length(); // 在leetcode可以加快速度
        for(int i = 0 ;i < length - 1; i++)
            res += Math.abs(s.charAt(i) - s.charAt(i+1));
        return res;
    }
}
