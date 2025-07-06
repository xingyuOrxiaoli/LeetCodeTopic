package simple.A242;

public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n1 != n2) return false;
        int[] dict = new int[26];
        for (int i = 0; i < n1; i++) {
            dict[s.charAt(i) - 'a'] ++;
            dict[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (dict[i] != 0) return false;
        }
        return true;
    }
}
