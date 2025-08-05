package simple.A面试题01_09;

public class 字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        return n == m && (s1 + s1).contains(s2);
    }
}
