package medium.A328;

import utils.ListNode;

import java.util.List;

public class 奇偶链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new 奇偶链表().oddEvenList(head);
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head  , even = head.next ,eventHead = even;

        while(true) {
            if(even.next == null) {
                break;
            }
            odd.next = even.next;
            odd = odd.next;
            if(odd.next == null) {
                break;
            }
            even.next = odd.next;
            even = even.next;
        }

        odd.next = eventHead;
        even.next = null;
        return head;
    }
}
