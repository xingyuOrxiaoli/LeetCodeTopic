package simple.A696;

import java.util.ArrayList;
import java.util.List;

public class 计数二进制子串 {

    public static void main(String[] args) {
        new 计数二进制子串().countBinarySubstrings("00110011");
    }
    public int countBinarySubstrings(String s) {
        int res = 0;
        List<Integer> list = new ArrayList<>();

        int n = s.length(), cur = 0, pre = 0;
        char ch = s.charAt(0);
        while (cur < n) {
            if (ch != s.charAt(cur)) {
                list.add(pre);
                pre = 0;
                ch = s.charAt(cur);
            }
            pre++;
            cur++;
        }
        list.add(pre);
        for (int i = 0; i < list.size() - 1; i++) {
            res += Math.min(list.get(i), list.get(i + 1));
        }
        return res;
    }
}
