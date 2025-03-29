package medium.A19;


import java.util.List;

public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode head  = new ListNode(1);
        ListNode temp = head;
        for(int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        new 删除链表的倒数第N个结点().removeNthFromEnd(head,2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode right = head;
        ListNode left = head;
        for( int i = 0 ; i < n ; i++){
            right = right.next;
        }
        if(right == null){
            return head.next;
        }
        while(right.next != null){
            right = right.next;
            left = left.next;
        }
        if(left.next == null) left = null;
        else left.next = left.next.next;
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