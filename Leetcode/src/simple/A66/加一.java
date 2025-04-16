package simple.A66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 加一 {
    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        int[] ints = new 加一().plusOne(digits);
        System.out.println(Arrays.toString(ints));

    }
    public int[] plusOne(int[] digits) {
        int n = digits.length , t = 1 ;
        List<Integer> list = new ArrayList<>(n);
        for(int i = n - 1 ; i > -1 ; i --){
            t += digits[i];
            list.add(t%10);
            t /= 10;
        }
        if(t != 0) list.add(t);
        int[] res = new int[list.size()];
        for(int i = list.size() - 1; i > -1 ; i --){
            res[list.size() - 1 - i] = list.get(i);
        }
        return res;
    }
}
