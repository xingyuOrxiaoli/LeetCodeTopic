package simple.A338;

public class 比特位计数 {
    public static void main(String[] args) {

    }
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i  = 1 ; i <= n ; i++)
            res[i] = res[i >> 1] + (i & 1);
        return res;
    }
}
