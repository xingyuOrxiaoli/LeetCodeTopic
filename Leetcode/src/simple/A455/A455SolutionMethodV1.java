package simple.A455;

import java.util.Arrays;

public class A455SolutionMethodV1 implements A455Solution{
    @Override
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0 ;
        int i = 0 , j = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                i ++;
                res++;
            }
            j ++;
        }
        return res;
    }
}
