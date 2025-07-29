package simple.A面试题0101;

public class 判定字符是否唯一 {
    public boolean isUnique(String astr) {
        int n = astr.length();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < n; i++) {
            char c = astr.charAt(i);
            if (visited[c - 'a']) return false;
            visited[c - 'a'] = true;
        }
        return true;
    }
}
