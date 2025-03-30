package Weekly_competition.one.A443;

public class Q2子字符串连接后的最长回文串I {
    public static void main(String[] args) {
        int i = new Q2子字符串连接后的最长回文串I().longestPalindrome("a","ae");
        System.out.println(i);
    }
    public int longestPalindrome(String s, String t) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (longestPalindrome(sub)) {
                    res = Math.max(res, sub.length());
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = i; j < t.length(); j++) {
                String sub = t.substring(i, j + 1);
                if (longestPalindrome(sub)) {
                    res = Math.max(res, sub.length());
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub_s = s.substring(i, j + 1);
                for (int k = 0; k < t.length(); k++) {
                    for (int l = k; l < t.length(); l++) {
                        String sub_t = t.substring(k, l + 1);
                        String sub_s_t = sub_s + sub_t;
                        if (longestPalindrome(sub_s_t)) {
                            res = Math.max(res, sub_s_t.length());
                        }
                    }
                }
            }
        }

        return res;
    }

    private boolean longestPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
