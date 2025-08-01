package simple.ALCR003;

public class 比特位计数 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int index = 0;
        for(int i = 1 ; i <= n ; i++) {
            if ((i & (i - 1)) == 0) index = i;
            res[i] = res[i - index] + 1;
        }
        return res;
    }
}
