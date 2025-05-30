package medium.A142;

import utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 环形链表II {
    public static void main(String[] args) {

    }

    // 方法 1 哈希表
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> dict = new HashSet<>();
        while(head != null){
            if(dict.contains(head)) return head;
            dict.add(head);
            head = head.next;
        }
        return null;
    }

    // 方法 2 快慢指针
    public ListNode detectCycle2(ListNode head) {

        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        ListNode cur = head;
        while(cur != slow){
            cur = cur.next;
            slow = slow.next;
        }
        return slow;
    }
}
