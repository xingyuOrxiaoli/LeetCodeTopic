package medium.A3713;

import java.util.Arrays;

public class 最长的平衡子串I {

    public static void main(String[] args) {
        System.out.println(new 最长的平衡子串I().longestBalanced("zzabccy"));
    }

    public int longestBalanced(String s) {
        int res = 0, n = s.length();
        int[] dict = new int[26];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dict, 0);
            for (int j = i; j < n; j++) {
                int endIndex = s.charAt(j) - 'a';
                dict[endIndex]++;
                int target = dict[endIndex];
//                System.out.println(i + " == " + j + " == " + target);
                if (check(dict, target)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean check(int[] dict, int target) {
        for (int i = 0; i < 26; i++) {
            if (dict[i] != target && dict[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
