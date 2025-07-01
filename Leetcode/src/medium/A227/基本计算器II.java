package medium.A227;

import java.util.Deque;
import java.util.LinkedList;

public class 基本计算器II {
    public static void main(String[] args) {
        int calculate = new 基本计算器II().calculate(" 3+5 / 2 ");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        Deque<Integer> number = new LinkedList<>();
        Deque<Integer> operator = new LinkedList<>(); // -1 1 加减  -2 2 // 乘除
        int n = s.length() , index = 0  , res = 0;
        operator.push(1);
        // 乘除
        while(index < n ){
            char ch = s.charAt(index ++);
            if(ch == ' ') continue;
            if(ch == '+') operator.push(1);
            else if(ch == '-') operator.push(-1);
            else if(ch >= '0' && ch <= '9'){
                int num = ch - '0';
                while(index < n && s.charAt(index) >='0' && s.charAt(index) <='9' ) num = num * 10 + s.charAt(index ++) - '0';
                number.push(num);
            }else{
                int pre = number.pop() , next = 0 ;
                while(index < n && (s.charAt(index) >='0' && s.charAt(index) <='9' || s.charAt(index) == ' ')){
                    if(s.charAt(index) == ' ') {
                        index ++;
                        continue;
                    }
                    next = next * 10  + s.charAt(index ++) - '0';
                }
                if(ch == '*') number.push(pre * next);
                else number.push(pre / next);
            }
        }

        // 加减
        while(!operator.isEmpty()){
            Integer op = operator.pop();
            res += op * number.pop();

        }

        return res;
    }

}
