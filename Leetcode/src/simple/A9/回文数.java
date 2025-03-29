package simple.A9;

public class 回文数 {
    public static void main(String[] args) {
        boolean palindrome = new 回文数().isPalindrome(121);
        System.out.println(palindrome);
    }
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int res =  0;
        int temp = x;
        while(temp != 0){
            res *= 10;
            res += (temp % 10);
            temp /= 10;
        }
        return x == res;
    }
}
