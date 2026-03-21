package simple.A476;

public class A476SolutionMethodV1  implements A476Solution{

    @Override
    public int findComplement(int num) {
        int res = 0;
        int upper = Integer.MAX_VALUE;
        for(int i = 1 ; i < 32 ; i ++) {
            if((upper >> i) >= num) {
                continue;
            }
            res = (upper >> (i - 1)) ^ num;
            break;
        }

        return res;
    }
}