package simple.A面试题02_01;

import utils.ListNode;

import java.util.*;

public class 移除重复节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        new 移除重复节点().removeDuplicateNodes(head);
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head , right = new ListNode(0 , cur);
        while (cur != null) {
            if(!set.contains(cur.val)) {
                set.add(cur.val);
                right.next = cur;
                right = cur;
            }
            cur = cur.next;
        }
        right.next = null;

        return head;
    }
}
