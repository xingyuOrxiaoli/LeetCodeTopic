package simple.A206;

import utils.ListNode;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null ;
        while(head.next != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }
}
