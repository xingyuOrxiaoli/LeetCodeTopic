package simple.A401;

import java.util.*;

public class A401SolutionMethodV1 implements A401Solution{
    @Override
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < 1024 ; i ++) {
            int h = i >> 6 , m = i & 63;
            if(h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                res.add(String.format("%02d:%02d", h, m));
            }
        }
        return res;
    }
}
