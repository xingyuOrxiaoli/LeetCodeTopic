package simple.A125;

public class 验证回文串 {
    public static void main(String[] args) {
        System.out.println((int)'a'); // 97
        System.out.println((int)'z'); // 122
        System.out.println((int)'A'); // 65
        System.out.println((int)'Z'); // 90
        System.out.println((int)'0'); // 48
        System.out.println((int)'9'); // 57

        boolean palindrome = new 验证回文串().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int left = 0 , right = s.length() - 1;
        while (left < right) {
            while(check(s.charAt(left))){
                left ++;
                if(left == s.length() || left > right) return true;
            }
            while(check(s.charAt(right))){
                right --;
                if(left > right) return true;
            }
            if(s.charAt(left ++ ) != s.charAt(right -- )) return false;
        }
        return true;
    }
    private boolean check(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) return false;
        return true;
    }
}
