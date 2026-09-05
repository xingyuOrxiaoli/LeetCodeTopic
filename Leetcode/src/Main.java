import java.util.*;

class MyStack {

    Stack<Integer> stack = new Stack<>();
    TreeMap<Integer,Integer> map = new TreeMap<>();
    public void push(int x) {
        stack.push(x);
        map.put(x,map.getOrDefault(x,0) + 1);
    }


    public int pop() {
        int key = stack.pop();
        int val = map.get(key) - 1;
        if (val == 0) {
            map.remove(val);
        }
        return stack.pop();
    }


    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public int getMin() {
        return map.firstKey();
    }
}
