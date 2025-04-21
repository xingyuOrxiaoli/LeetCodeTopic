package medium.A61;


public class 旋转链表 {
    public static void main(String[] args) {
        for(int k = 2 ; k <= 1e9 * 2 ; k ++) {
            for (int i = 3; i <= 500; i++) {
                ListNode head = null;
                ListNode tail = null;
                ListNode temp1 = head;
                ListNode temp2 = tail;
                for (int j = 0; j < i; j++) {
                    if (temp1 == null) {
                        temp1 = new ListNode(j);
                        head = temp1;
                        temp2 = new ListNode(j);
                        tail = temp2;
                        continue;
                    }
                    temp1.next = new ListNode(j);
                    temp1 = temp1.next;
                    temp2.next = new ListNode(j);
                    temp2 = temp2.next;
                }

                ListNode listNode = new 旋转链表().rotateRight_2(head, k);
                StringBuilder myres = getStringListNode(listNode);
                StringBuilder leetcode = getStringListNode(new Solution().rotateRight(tail, k));
                if (leetcode.toString().equals(myres.toString())) {
                    System.out.println( "[INFO] k =" + k + "通过测试用例 head = " + getStringListNode(head)+ "res = " + myres);
                }else{
                    myres = getStringListNode(listNode);
                    System.out.println( "[WARN] k =" + k + "未通过测试用例 head = " + getStringListNode(head)+ "res = " + myres + "leetcode = " + leetcode);
                    return;
                }

            }
        }
        System.out.println("[INFO] 通过所有测试案例");

    }
    public static StringBuilder getStringListNode(ListNode head) {
        StringBuilder res = new StringBuilder("[");
        while (head != null) {
            res.append(head.val + ",");
            head = head.next;
        }
        res.append("]");
        return res;
    }
    public ListNode rotateRight(ListNode head, int k) {

        if(k == 0 || head == null || head.next == null) return head;
        int n = 0 ;
        ListNode temp = head;
        while (temp!= null) {
            n ++;
            temp = temp.next;
        }

        if(n <= k ) return rotateRight(head , k % n);
        ListNode right = head, left = head;
        for(int i = 0 ; i < k ; i ++) right = right.next;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        right.next = head;
        head = left.next;
        left.next = null;
        return head;
    }

    // 练习2
    public ListNode rotateRight_2(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = 0 ;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n ++;
        }
         k = k % n;
        if(k == 0) return head;
        ListNode pre = new ListNode() , end = head;
        pre.next = head;
        while(k != 1){
            end = end.next;
            k -- ;
        }
        while(end.next != null){
            end = end.next;
            pre= pre.next;
        }
        end.next = head;
        head = pre.next;
        pre.next = null;
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

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}