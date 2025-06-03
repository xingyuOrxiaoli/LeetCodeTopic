package medium.A150;

import java.util.Stack;

public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        String[] tokens = {
                "4","13","5","/","+"
        };
        System.out.println(new 逆波兰表达式求值().evalRPN(tokens));

    }
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int x = Integer.parseInt(stack.pop());
                    int y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(x + y));
                    break;
                case "-":
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y - x));
                    break;
                case "*":
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(x * y));
                    break;
                case "/":
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y / x));
                    break;
                default:
                    stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
