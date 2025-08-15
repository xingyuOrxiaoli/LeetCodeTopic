package simple.A面试题02_06;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        boolean palindrome = new 回文链表().isPalindrome(head);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for(int i = 0 , j = list.size() - 1 ; i < j ; i ++ , j --)
            if(!list.get(i) .equals(list.get(j))) return false;

        return true;
    }
}
