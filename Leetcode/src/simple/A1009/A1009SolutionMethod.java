package simple.A1009;

public class A1009SolutionMethod implements A1009Solution {
    @Override
    public int bitwiseComplement(int n) {
        int res = 0;
        if (n == 0) {
            return 1;
        }

        int bit = 0;
        while (n != 0) {
            int temp = n & 1;
            temp ^= 1;
            temp <<= bit++;
            res += temp;
            n >>= 1;
        }
        return res;
    }
}
