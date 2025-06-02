package medium.A143;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 重排链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new 重排链表().reorderList(head);
    }
    // 存储到数组中
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int n = list.size();
        for (int i = 0; i < (n >> 1); i++) {
            list.get(i).next = list.get(n - i - 1 );
            list.get(n - i - 1).next = list.get(i + 1);
        }
        list.get((n >> 1)).next = null;
    }
}
