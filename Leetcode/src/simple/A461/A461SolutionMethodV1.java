package simple.A461;

public class A461SolutionMethodV1  implements A461Solution{

    @Override
    public int hammingDistance(int x, int y) {
        int res = 0 ;
        while(x != 0 || y != 0){
            if((x & 1) != (y & 1)) {
                res ++;
            }
            x >>= 1;
            y >>= 1;
        }
        return res;
    }
}