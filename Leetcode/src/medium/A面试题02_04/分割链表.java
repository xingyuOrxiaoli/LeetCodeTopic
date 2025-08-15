package medium.A面试题02_04;

import utils.ListNode;

import java.util.List;

public class 分割链表 {
    public ListNode partition(ListNode head, int x) {

        ListNode left = null, right = null , l  = null , r =null ;
        while (head != null) {
            if(head.val < x){
                if(left == null) {
                    left = head;
                    l = left;
                }
                else {
                    left.next = head;
                    left = head;
                }
            }else{
                if(right == null) {
                    right = head;
                    r = right;
                }
                else {
                    right.next = head;
                    right = head;
                }
            }
            head = head.next;
        }
        if(left != null) left.next = r;
        if(right != null) right.next = null;

        return l == null? r : l;
    }
}
