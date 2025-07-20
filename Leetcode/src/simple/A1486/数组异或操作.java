package simple.A1486;

public class 数组异或操作 {
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0 ; i < n ; i ++){
            res ^= (start + (i << 1));
        }

        return res;
    }
}
