package medium.A328;

import utils.ListNode;

public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head , even = head.next , evenHead = even;
        while(odd != null && even != null) {
            if(even.next == null) break;
            odd.next = even.next;
            odd = odd.next;
            if(odd.next == null) break;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}
