package medium.A148;

import utils.ListNode;

public class 排序链表 {

    public ListNode sortList(ListNode head) {
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        ListNode cur = head;
        while(cur != null) {
            max = Math.max(max, cur.val);
            min = Math.min(min, cur.val);
            cur = cur.next;
        }
        int n = max - min + 1 ;
        int[] arr = new int[n];
        cur = head;
        while(cur != null) {
            arr[cur.val - min]++;
            cur = cur.next;
        }
        cur = head;
        for(int i = 0 ; i < n ; i ++) {
            if(arr[i] == 0) continue;
            while(arr[i] != 0){
                cur.val = i + min;
                arr[i] --;
                cur = cur.next;
            }
        }
        return head;
    }
}
