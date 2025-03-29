package simple.A21;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        new 合并两个有序链表().mergeTwoLists(l1,l2);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val > list2.val) return mergeTwoLists(list2,list1);

        ListNode res = list1;
        ListNode temp1 = list1.next;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null){
            if(temp1.val > temp2.val){
                list1.next = temp2;
                list1 = temp2;
                temp2 = temp2.next;
            }else{
                list1.next = temp1;
                list1 = temp1;
                temp1 = temp1.next;
            }
        }
        if(temp1 != null) list1.next = temp1;
        if(temp2 != null) list1.next = temp2;

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