package A面试题03_04;

import java.util.Stack;

public class 化栈为队 {
}
class MyQueue {

    private Stack<Integer> stack1 ;
    private Stack<Integer> stack2 ;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!this.stack1.isEmpty()) this.stack2.push(this.stack1.pop());
        int res = this.stack1.pop();
        while(!this.stack2.isEmpty()) this.stack1.push(this.stack2.pop());

        return res;
    }

    /** Get the front element. */
    public int peek() {
        while(!this.stack1.isEmpty()) this.stack2.push(this.stack1.pop());
        int res = this.stack1.peek();
        while(!this.stack2.isEmpty()) this.stack1.push(this.stack2.pop());

        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */