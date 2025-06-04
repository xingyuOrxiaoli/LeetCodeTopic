package simple.A171;

public class Excel表列序号 {
    public static void main(String[] args) {

    }
    public int titleToNumber(String columnTitle) {
        int res = 0  , n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            int t = columnTitle.charAt(i) - 'A' + 1;
            res *= 26;
            res += t;
        }
        return res;
    }
}
