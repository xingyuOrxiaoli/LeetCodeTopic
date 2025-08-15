package medium.A面试题02_05;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 链表求和 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null , cur = res;
        int t = 0 ;
        while(l1 != null && l2 != null){
            t += l1.val + l2.val ;
            ListNode temp = new ListNode(t % 10);
            if(cur == null) res = temp;
            else cur.next = temp;
            cur = temp;
            t /= 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            t += l1.val;
            ListNode temp = new ListNode(t % 10);
            if(cur == null) res = temp;
            else cur.next = temp;
            cur = temp;
            t /= 10;
            l1 = l1.next;
        }

        while (l2 != null){
            t += l2.val;
            ListNode temp = new ListNode(t % 10);
            if(cur == null) res = temp;
            else cur.next = temp;
            cur = temp;
            t /= 10;
            l2 = l2.next;
        }
        if(t != 0)  cur.next = new ListNode(t);
        return res;
    }

}
