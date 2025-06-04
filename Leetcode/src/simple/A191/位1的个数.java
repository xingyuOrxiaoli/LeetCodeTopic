package simple.A191;

public class 位1的个数 {
    public static void main(String[] args) {

    }
    public int hammingWeight(int n) {
        int res = 0 ;
        while (n != 0) {
            if((n & 1) == 1) res++;
            n = n >> 1;
        }
        return res;
    }
}
