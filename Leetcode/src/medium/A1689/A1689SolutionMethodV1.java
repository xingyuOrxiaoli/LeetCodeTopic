package medium.A1689;

import java.util.Arrays;

public class A1689SolutionMethodV1 implements A1689Solution{
    @Override
    public int minPartitions(String n) {
        int res = 0;
        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
        }
        return res;
    }
}
