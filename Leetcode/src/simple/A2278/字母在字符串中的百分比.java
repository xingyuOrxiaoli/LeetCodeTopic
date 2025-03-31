package simple.A2278;

public class 字母在字符串中的百分比 {
    public static void main(String[] args) {
        int i = new 字母在字符串中的百分比().percentageLetter("foobar",'k');
        System.out.println(i);
    }

    public int percentageLetter(String s, char letter) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) {
                res ++;
            }
        }
        res = (res * 100) / n;
        return res;
    }
}
