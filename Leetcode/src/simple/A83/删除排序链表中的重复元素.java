package simple.A83;

import java.util.List;

public class 删除排序链表中的重复元素 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = new 删除排序链表中的重复元素().deleteDuplicates(head);

    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode left = head , right = head.next;
        while(right != null){
            if(right.val != left.val){
                left.next = right;
                left = right;
            }
            right = right.next;
        }
        left.next = null;
        return head;
    }
    

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
