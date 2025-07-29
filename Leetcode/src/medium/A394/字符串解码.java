package medium.A394;

import java.util.Stack;

public class 字符串解码 {
    public static void main(String[] args) {
        String res = new 字符串解码().decodeString("3[a]2[bc]");
        System.out.println(res);
    }
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder() , t = new StringBuilder();
        Stack<StringBuilder> stack_str = new Stack<>();
        Stack<Integer> stack_num = new Stack<>();
        stack_str.push(res);
        int num = 0 , isDecode = 0;
        for (char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                if( num == 0 && (stack_str.isEmpty() || isDecode != 0)){
                    stack_str.push(t);
                    t = new StringBuilder();
                }
                num = num * 10 + ch - '0';
            }
            else {
                if(ch == '[') {
                    stack_num.push(num);
                    num = 0 ;
                    isDecode ++;
                    continue;
                }
                else if(ch == ']'){
                    isDecode --;
                    int n = stack_num.pop();
                    StringBuilder str = stack_str.pop();
                    for(int i = 0 ; i < n ; i++) str.append(t);
                    t = str;
                }else if(isDecode != 0) t.append(ch);

                if(isDecode == 0 && ch != ']') res.append(ch);
            }
        }
        return res.toString();
    }
}
