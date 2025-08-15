package simple.A面试题02_03;

import utils.ListNode;

public class 删除中间节点 {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
