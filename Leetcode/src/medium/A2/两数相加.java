package medium.A2;


import java.util.List;

public class 两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode temp = l1;
        for(int i = 2 ;i <=3 ; i++){
             temp.next = new ListNode(i);
             temp = temp.next;
        }
        ListNode l2 = new ListNode(4);
        temp = l2;
        for(int i = 5 ;i <=6 ; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        new 两数相加().addTwoNumbers(l1,l2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return (l1 == null)?l2:l1;
        ListNode res = new ListNode();
        ListNode tempNode = res;
        int temp = 0;
        while(l1 != null && l2 != null){
            temp += l1.val + l2.val;
            tempNode.val = temp %10;
            temp /= 10;
            l1 = l1.next;
            l2 = l2.next;
            tempNode.next = new ListNode();
            if(l1 != null || l2 != null) tempNode = tempNode.next;
        }
        while(l1 != null){
            temp += l1.val;
            tempNode.val = temp%10;
            temp /= 10;
            if(l1.next != null){
                tempNode.next = new ListNode();
                tempNode = tempNode.next;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            temp += l2.val;
            tempNode.val = temp %10;
            temp /= 10;
            if(l2.next != null){
                tempNode.next = new ListNode();
                tempNode = tempNode.next;
            }
            l2 = l2.next;
        }
        if(temp != 0){
            tempNode.next = new ListNode(temp);
        }else{
            tempNode.next = null;
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
