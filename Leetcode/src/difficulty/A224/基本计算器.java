package difficulty.A224;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 基本计算器 {
    public static void main(String[] args) {
        int calculate = new 基本计算器().calculate("2147483647");
        System.out.println(calculate);
    }
    public int calculate(String s) {
        int res = 0 , n = s.length() , index = 0 , op = 1;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(op);
        while(index < n){
            char c = s.charAt(index ++);
            if(c == ' ') continue;
            if(c == '+') op = stack.peek();
            else if(c == '-') op = -stack.peek();
            else if(c == '(') stack.push(op);
            else if(c == ')') stack.pop();
            else{
                    int temp = 0 , j = index - 1;
                    while(j < n && s.charAt(j) >='0' && s.charAt(j) <= '9'){
                        c = s.charAt(j ++);
                        temp = temp * 10 + c - '0';
                    }
                    index = j ;
                res += temp * op;
            }
        }
        return res ;
    }
}
