package simple.A13;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {
    public static void main(String[] args) {
        int i = new 罗马数字转整数().romanToInt("III");
        System.out.println(i);
    }
    public int romanToInt(String s) {
        int res = 0;
        char[] ch  = s.toCharArray();
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char temp1;
        char temp2;
        int value1 = -1;
        int value2 = -1;
        for(int i = 0 ; i < length; i++){
            temp1= ch[i];

            value1= map.get(temp1);
            if(i + 1 < length){
                temp2 = ch[i +1];
                value2= map.get(temp2);
            }
            if(i + 1 < length && value2 > value1){
                res += (value2 - value1);
                i ++;
            }else{
                res += value1;
            }
        }
        return res;
    }
}
