package medium.A151;

public class 反转字符串中的单词 {
    public static void main(String[] args) {
        String s = new 反转字符串中的单词().reverseWords("  hello    world  ");
        System.out.println(s);
    }
    public String reverseWords(String s) {
        String trim = " " + s.trim();
        StringBuilder res = new StringBuilder();
        int n = trim.length() , right = n;
        for(int i = n - 1 ; i > -1 ; i--) {
            if(trim.charAt(i) != ' ') continue;
            if(trim.charAt(i) == ' ' && trim.charAt(i + 1) == ' ') {
                right --;
                continue;
            }
            res.append(trim.substring(i + 1 , right));
            if(i != 0) res.append(' ');
            right = i;
        }

        return res.toString();
    }
}
