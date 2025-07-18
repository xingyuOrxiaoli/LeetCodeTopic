package simple.A345;

public class 反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        int left = 0 , right = s.length() - 1;
        StringBuffer res = new StringBuffer(s);
        while(left < right) {
            if(isValid(s.charAt(left))) {
                if(isValid(s.charAt(right))) {
                    char temp = s.charAt(left);
                    res.deleteCharAt(left);
                    res.insert(left, s.charAt(right));
                    res.deleteCharAt(right);
                    res.insert(right, temp);
                    left ++;
                    right --;
                }else right --;
            }else left ++;
        }


        return res.toString();
    }
    private boolean isValid(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
