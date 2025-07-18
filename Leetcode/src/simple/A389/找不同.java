package simple.A389;

public class 找不同 {
    public char findTheDifference(String s, String t) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++)  count[s.charAt(i) - 'a']++;
        for (int i = 0; i <= n; i++) {
            int ch = t.charAt(i) - 'a';
            if(count[ch] == 0) return (char) (ch + 'a');
            count[ch]--;
        }

        return ' ';
    }
}
