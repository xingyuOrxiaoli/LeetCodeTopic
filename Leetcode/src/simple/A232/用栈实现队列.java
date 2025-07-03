package simple.A232;

import java.util.Stack;

public class 用栈实现队列 {
    public static void main(String[] args) {

    }
}
class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while(stack1.size() > 1) stack2.push(stack1.pop());
        Integer pop = stack1.pop();

        while(!stack2.isEmpty()) stack1.push(stack2.pop());

        return pop;
    }

    public int peek() {
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        Integer peek = stack2.peek();

        while(!stack2.isEmpty()) stack1.push(stack2.pop());

        return peek;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}