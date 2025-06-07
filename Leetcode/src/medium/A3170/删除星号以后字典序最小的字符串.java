package medium.A3170;

public class 删除星号以后字典序最小的字符串 {
    public static void main(String[] args) {
        String s = new 删除星号以后字典序最小的字符串().clearStars("aaba*");
        System.out.println(s);
    }
    public String clearStars(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length() ;
        int[] dict = new int[26];
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '*') {
                for(int j = 0 ; j < 26 ; j++) {
                    if(dict[j] != 0) {
                        dict[j]--;
                        res.deleteCharAt(res.lastIndexOf(String.valueOf((char)('a' + j))));
                        break;
                    }
                }
            }else{
                res.append(s.charAt(i));
                dict[s.charAt(i) - 'a'] ++;
            }
        }
        return res.toString();
    }
}
