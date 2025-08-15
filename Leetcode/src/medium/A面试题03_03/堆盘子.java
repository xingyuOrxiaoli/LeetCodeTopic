package medium.A面试题03_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 堆盘子 {
}

class StackOfPlates {

    List<Stack<Integer>> stack = new ArrayList<>();
    int cap  , index = -1;
    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if(this.cap == 0) return;
        if(index == -1 || stack.get(index).size() == cap){
            stack.add(new Stack<>());
            index ++;
        }
        stack.get(index).add(val);
    }

    public int pop() {
        if(index == -1) return -1;
        int res =  stack.get(index).pop();
        if(stack.get(index).isEmpty()){
            stack.remove(index);
            index --;
        }
        return res;
    }

    public int popAt(int index) {
        if(index >= stack.size()) return -1;
        int res =  stack.get(index).pop();
        if(stack.get(index).isEmpty()){
            stack.remove(index);
            this.index --;
        }
        return res;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */