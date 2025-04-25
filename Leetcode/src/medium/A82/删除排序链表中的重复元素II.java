package medium.A82;


import java.util.List;

public class 删除排序链表中的重复元素II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2 ; i <= 4 ; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = new ListNode(5);
        temp = temp.next;
        ListNode listNode = new 删除排序链表中的重复元素II().deleteDuplicates(head);
        System.out.println(listNode);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode cur = head, prev = new ListNode(-200, head) , res = null;
        while(cur != null){
            if(prev.val != cur.val && (cur.next == null || cur.next.val != cur.val)){
                if(res == null) head = cur;
                if(res != null) res.next = cur;
                res = cur;
            }
            prev = cur;
            cur = cur.next;
        }
        if(res != null ) res.next = cur;
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
