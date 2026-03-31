package simple.A680;

public class A680SolutionMethodV1  implements A680Solution{

    @Override
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0 , right = n - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            } else {
                return validPalindrome(s,left , right - 1) || validPalindrome(s,left + 1 , right);
            }
        }
        return true;
    }
    public boolean validPalindrome(String s , int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left ++;
                right --;
            }
        }
        return true;
    }
}