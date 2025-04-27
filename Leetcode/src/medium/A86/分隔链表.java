package medium.A86;


public class 分隔链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);

        ListNode partition = new 分隔链表().partition(head, 3);
        System.out.println(partition);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode left = null, right = null , temp = head,rightHead = null;
        while (temp != null) {
            if(temp.val < x){
                if(left == null) head = temp;
                else left.next = temp;
                left = temp;
            }else{
                if(right != null) right.next = temp;
                else rightHead = temp;
                right = temp;
            }
            temp = temp.next;
        }
        if(left  != null) left.next = rightHead;
        if(right != null ) right.next = null;

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
