package simple.A441;

public class A441SolutionMethodV1 implements A441Solution{
    @Override
    public int arrangeCoins(int n) {
        int res = 0 , x = 1;
        while(n > 0) {
            if(n >= x) {
                res ++;
            }
            n -= x;
            x ++;
        }
        return res;
    }
}
