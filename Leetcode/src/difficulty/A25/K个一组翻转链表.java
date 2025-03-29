package difficulty.A25;

public class K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2 ; i <= 4 ; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        new K个一组翻转链表().reverseKGroup(head,4);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] node = new ListNode[k + 1];
        ListNode temp = head;
        while(temp != null){
            for(int i = 1 ; i < k + 1 ; i++){
                if(temp == null){return head;}
                node[i] = temp;
                temp = temp.next;
            }
            // 存在一次呼唤交换返回的接单真正的头节点位置
            if(head == node[1]){
                head = node[k];
            }
            reverseKGroup(node,k + 1);
            node[0] = node[k];
        }

        return head;
    }

    private void reverseKGroup(ListNode[] node,int k) {
        int n = k >> 1;
        for(int i = 1 ;i <= n ; i++){
            int temp = k - i;
            if(temp == i ) continue;
            // 前节单的交换
            if(node[i - 1] != null){
                node[i - 1].next = node[temp];
            }
            node[temp - 1].next = node[i];
            // 后节点交换
            ListNode next = node[i].next;
            node[i].next = node[temp].next;
            node[temp].next = next;

            // 交换数组元素
            next = node[temp];
            node[temp] = node[i];
            node[i] = next;

        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}