package simple.A203;

import utils.ListNode;

public class 移除链表元素 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        new 移除链表元素().removeElements(head,6);
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;

        ListNode cur = head.next , prev = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            }else{
//                prev.next = cur;
                prev = prev.next;
            }

            cur = cur.next;
        }
        return head;
    }
}
