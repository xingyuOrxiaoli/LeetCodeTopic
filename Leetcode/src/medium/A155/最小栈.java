package medium.A155;

import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class 最小栈 {

}
class MinStack {

    Stack<Integer> stack;
    TreeMap<Integer,Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new TreeMap<>();
    }

    public void push(int val) {
        stack.push(val);
        min.put(val,min.getOrDefault(val,0) + 1);
    }

    public void pop() {
        min.put(stack.peek(), min.get(stack.peek()) - 1);
        if (min.get(stack.peek()) == 0) min.remove(stack.peek());
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.firstKey();
    }
}