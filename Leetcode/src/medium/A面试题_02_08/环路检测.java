package medium.A面试题_02_08;

import utils.ListNode;

public class 环路检测 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head , fast = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            if(fast.next != null) fast = fast.next.next;
            else return null;

            if(fast == slow){
                ListNode cur = head;
                while (cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }

        return null;
    }
}
