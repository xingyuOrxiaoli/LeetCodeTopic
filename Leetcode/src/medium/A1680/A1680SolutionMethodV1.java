package medium.A1680;

public class A1680SolutionMethodV1 implements A1680Solution {

    @Override
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long l = getMaxBinary(n) % mod;
        long res = n;
        for (int i = n - 1; i > 0; i--) {
            long temp = i * l % mod;
            l = l * (getMaxBinary(i) % mod) % mod;
            res = res + temp % mod;
        }
        return (int) (res % mod);
    }

    private long getMaxBinary(int n) {
        int res = 1;

        while (res <= n) {
            res <<= 1;
        }
        return res;
    }

}
