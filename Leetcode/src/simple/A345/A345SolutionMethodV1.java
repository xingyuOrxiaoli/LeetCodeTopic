package simple.A345;


public class A345SolutionMethodV1 implements A345Solution {
    @Override
    public String reverseVowels(String s) {

        int left = 0, right = s.length() - 1;
        StringBuilder res = new StringBuilder(s);
        while (left < right) {
            char lc = s.charAt(left);
            if (isValid(lc)) {
                char rc = s.charAt(right);
                if (isValid(rc)) {
                    res.deleteCharAt(left);
                    res.insert(left, rc);
                    res.deleteCharAt(right);
                    res.insert(right, lc);
                    left++;
                }
                right--;

            } else {
                left++;
            }
        }

        return res.toString();
    }

    private boolean isValid(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
