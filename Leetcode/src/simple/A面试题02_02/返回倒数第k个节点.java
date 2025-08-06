package simple.A面试题02_02;

import utils.ListNode;

public class 返回倒数第k个节点 {

    public int kthToLast(ListNode head, int k) {
        ListNode left = head , right = head;
        while(k != 0) {
            right = right.next;
            k --;
        }
        while(right != null) {
            left = left.next;
            right = right.next;
        }
        return left.val;

    }
}
