package medium.A1545;

public class A1545SolutionMethodV1 implements A1545Solution {
    @Override
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");

        while (s.length() < k) {
            s.append("1");
            reverseInvert(s);
        }
        return s.charAt(k - 1);
    }

    private void reverseInvert(StringBuilder s) {
        int n = s.length() - 1;
        StringBuilder temp = new StringBuilder(n);
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                temp.append('1');
            } else {
                temp.append('0');
            }
        }
        s.append(temp);
    }
}
