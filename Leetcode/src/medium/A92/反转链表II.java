package medium.A92;

import utils.ListNode;

public class 反转链表II {


    public static void main(String[] args) {
        ListNode listNode = ListNode.create("[1,2,3,4,5]");
        listNode.print();
        ListNode listNode1 = new 反转链表II().reverseBetween(listNode, 2, 5);
        listNode1.print();
    }

    // 方法 1
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int[] arr = new int[right + 1];
        arr[left - 1] = 600;
        ListNode cur = head;
        for(int i = 0 ; i < left - 1; i++) cur = cur.next;
        ListNode temp = cur;
        while(left <= right) {
            arr[left++] = temp.val;
            temp = temp.next;
        }
        while(arr[right] != 600){
            cur.val = arr[right--];
            cur = cur.next;
        }
        return head;
    }
}
