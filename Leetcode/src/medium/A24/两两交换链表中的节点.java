package medium.A24;

public class 两两交换链表中的节点 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2 ; i <= 4 ; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        new 两两交换链表中的节点().swapPairs(head);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode left = head;
        ListNode right = left.next;
        ListNode pre = null;
        if(right != null) head = right;
        while(left != null && right != null){
            if(pre != null){
                pre.next = right;
            }
            pre = left;
            // 交换
            left.next  =  right.next;
            right.next =  left;

            left = left.next;
            if(left == null) break;
            right = left.next;

        }
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
