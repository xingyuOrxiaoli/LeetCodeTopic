package medium.A1545;

public class A1545SolutionMethodV2 implements A1545Solution {


    @Override
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int mid = 1 << (n - 1);
        if (mid == k) {
            return '1';
        } else if (mid > k) {
            return findKthBit(n - 1, k);
        } else {
             k = mid * 2 - k;
            return (char) ('1' - findKthBit(n - 1, k) + '0');
        }
    }
}
