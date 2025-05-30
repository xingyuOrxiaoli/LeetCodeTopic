package simple.A141;

import utils.ListNode;

import java.util.HashSet;
import java.util.TreeSet;

public class 环形链表 {
    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head;

        boolean b = new 环形链表().hasCycle(head);
        System.out.println(b);
    }

    //  方法 1 哈希表
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> dict = new HashSet<>();
        while(head != null){
            if(dict.contains(head)) return true;
            dict.add(head);
            head = head.next;
        }
        return false;
    }

    // 方法 2 快慢指针
    public boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
