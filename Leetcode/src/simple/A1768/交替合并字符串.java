package simple.A1768;

public class 交替合并字符串 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0  ,n = word1.length(), m = word2.length();
        while (i < n && j < m) {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }
        while (i < n) res.append(word1.charAt(i++));
        while (j < m) res.append(word2.charAt(j++));
        return res.toString();
    }
}
