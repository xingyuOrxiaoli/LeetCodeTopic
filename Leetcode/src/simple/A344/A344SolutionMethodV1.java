package simple.A344;

public class A344SolutionMethodV1 implements A344Solution {
    @Override
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[right] ^ s[left]);
            s[left] = (char) (s[left ++ ] ^ s[right --]);
        }
    }
}
