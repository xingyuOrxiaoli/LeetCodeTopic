package medium.A166;

import java.util.HashMap;
import java.util.Locale;

public class 分数到小数 {
    public static void main(String[] args) {
        String s = new 分数到小数().fractionToDecimal(7, -12);
        System.out.println(s);
    }
    public String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder() , prefix = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            prefix.append('-');
        }
        long numerator_long = numerator;
        long denominator_long = denominator;

        numerator_long = Math.abs(numerator_long);
        denominator_long = Math.abs(denominator_long);

        prefix.append(numerator_long / denominator_long);
        numerator_long %= denominator_long;
        if(numerator_long == 0) return prefix.toString();

        HashMap<Long , Integer> map = new HashMap<>();
        int index = 0 ;
        while(numerator_long != 0 && !map.containsKey(numerator_long)){
            map.put(numerator_long,index++);
            numerator_long *= 10;
            result.append(numerator_long / denominator_long);
            numerator_long %= denominator_long;
        }
        StringBuilder last = new StringBuilder();
        if(numerator_long != 0 ){
            Integer value = map.get(numerator_long);
            if(value > 0) last.append(result.substring(0,value));
            last.append("(");
            last.append(result.substring(value));
            last.append(")");
        }else last = result;

        return prefix +"."+last;
    }

}
