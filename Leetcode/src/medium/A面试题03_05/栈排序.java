package medium.A面试题03_05;

import java.util.Stack;

public class 栈排序 {
}
class SortedStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();

    public SortedStack() {
    }

    public void push(int val) {
        int max = stack.isEmpty()?Integer.MAX_VALUE:stack.peek();
        int min = tempStack.isEmpty()?Integer.MIN_VALUE:tempStack.peek();

        while(true){
            if(val > max){
                tempStack.push(stack.pop());
                max = stack.isEmpty()?Integer.MAX_VALUE:stack.peek();
            }else if(val < min){
                stack.push(tempStack.pop());
                min = tempStack.isEmpty()?Integer.MIN_VALUE:tempStack.peek();
            }else{
                stack.push(val);
                break;
            }
        }

    }

    public void pop() {
        while(!tempStack.isEmpty()) stack.push(tempStack.pop());
        if(!stack.isEmpty()) stack.pop();
    }

    public int peek() {
        while(!tempStack.isEmpty()) stack.push(tempStack.pop());
        return stack.isEmpty()?-1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && tempStack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */