package simple.A383;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int n = ransomNote.length(), m = magazine.length();
        if(n > m ) return false;
        for (int i = 0; i < m; i++) count[magazine.charAt(i) - 'a']++;
        for (int i = 0 ; i < n ; i ++){
            char ch = ransomNote.charAt(i);
            if(count[ch - 'a'] == 0) return false;
            count[ch - 'a']--;
        }
        return true;
    }
}
