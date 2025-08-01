package simple.A面试题01_02;

public class 判定是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        int res = 0 ;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            if(count[c - 'a'] == 0) res ++;
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
            if(count[c - 'a'] == 0) res --;
            if(count[c - 'a'] < 0) return false;
        }
        return res == 0;
    }
}
