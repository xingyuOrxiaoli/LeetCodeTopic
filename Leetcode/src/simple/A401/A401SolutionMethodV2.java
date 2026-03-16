package simple.A401;

import java.util.ArrayList;
import java.util.List;

public class A401SolutionMethodV2 implements A401Solution{
    @Override
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int h = 0 ; h < 12 ; h++){
            for(int m = 0 ; m < 60 ; m++){
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    res.add(String.format("%d:%02d",h,m));
                }
            }
        }
        return res;
    }
}
