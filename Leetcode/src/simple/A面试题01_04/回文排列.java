package simple.A面试题01_04;

public class 回文排列 {
    public boolean canPermutePalindrome(String s) {
        int  n = s.length() , odd = 0;
        int[] arr = new int[256];
        for(int i = 0 ; i < n ; i++){
            arr[s.charAt(i)]++;
            if((arr[s.charAt(i)] & 1) == 1) odd --;
            else odd ++;
        }
        return odd > -2;
    }
}
