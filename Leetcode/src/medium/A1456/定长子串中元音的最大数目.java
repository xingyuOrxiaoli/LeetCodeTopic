package medium.A1456;

public class 定长子串中元音的最大数目 {
    public int maxVowels(String s, int k) {
        int res  = 0 , n = s.length() , left = 0;
        for(int i  = 0 ; i < k && i < n ; i ++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') res ++;
        }
        int t = res ;
        for(int i = k ; i < n; i ++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') t ++;
            ch = s.charAt(left ++);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') t --;
            res = Math.max(res, t);
        }

        return res;
    }
}
