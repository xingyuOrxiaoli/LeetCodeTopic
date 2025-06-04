package simple.A160;

import utils.ListNode;

import java.util.Stack;

public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack() , stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            if(nodeA == nodeB){
                if(stackA.isEmpty() || stackB.isEmpty()) return nodeA;
                if (stackA.peek() != stackB.peek()) return nodeA;
            }
        }
        return null;
    }
}
