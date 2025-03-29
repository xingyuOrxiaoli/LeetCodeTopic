package difficulty.A23;

public class 合并K个升序链表 {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[1] = new ListNode(1);
        listNodes[2] = new ListNode(2);
        listNodes[0].next = new ListNode(4,new ListNode(5));
        listNodes[1].next = new ListNode(3,new ListNode(4));
        listNodes[2].next = new ListNode(6);
        new 合并K个升序链表().mergeKLists(listNodes);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length == 0) return null;
        if(length == 1) return lists[0];
        ListNode res = lists[0];
        // 方法一
        // for(int i = 1 ;i < length ; i++){
        //    res =  merge(res,lists[i]);
        // }
        // 方法二
        res = merge(lists,0 ,length -1);
        return  res;
    }
    public ListNode merge(ListNode[] lists,int left , int right){
        if(left == right){
            return lists[left];
        }
        if(left > right){
            return null;
        }
        int mid = (left + right) >> 1;
        return merge(merge(lists,left,mid),merge(lists,mid+ 1, right));
    }
    public ListNode merge(ListNode list1 , ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val > list2.val) return merge(list2,list1);

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