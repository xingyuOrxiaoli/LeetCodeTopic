package simple.A2413;

public class 最小偶倍数 {
    public int smallestEvenMultiple(int n) {
        if((n & 1) == 1) return n << 1;
        return n;
    }
}
