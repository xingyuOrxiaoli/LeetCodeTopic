package simple.A225;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }
}
class MyStack {

    private Queue<Integer> queue1 ;
    private Queue<Integer> queue2 ;
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while(queue1.size() != 1){
            queue2.offer(queue1.poll());
        }
        int pop = queue1.poll();
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return pop;
    }

    public int top() {
        int top = 0;
        while(!queue1.isEmpty()){
            if(queue1.size() == 1) top = queue1.peek();
            queue2.offer(queue1.poll());
        }
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}