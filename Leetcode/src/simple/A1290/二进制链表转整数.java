package simple.A1290;

import utils.ListNode;

public class 二进制链表转整数 {


    public int getDecimalValue(ListNode head) {
        int res  = 0;

        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}
