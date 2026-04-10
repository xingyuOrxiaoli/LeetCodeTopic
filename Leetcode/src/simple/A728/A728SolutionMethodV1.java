package simple.A728;

import java.util.ArrayList;
import java.util.List;

public class A728SolutionMethodV1  implements A728Solution{

    @Override
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(isCheck(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isCheck(int num) {
        int t = num;
        while(t > 0) {
            int rem = t % 10;
            if ( rem == 0 || num % rem != 0) {
                return false;
            }
            t = t / 10;
        }
        return true;
    }
}