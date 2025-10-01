package medium.A面试题04_03;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 特定深度节点链表 {

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        ListNode curNode = null;
        queue.add(tree);
        levels.add(1);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levels.poll();

            if (node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }

            if(list.size() != level){
                curNode = new ListNode(node.val);
                list.add(curNode);
            }else {
                curNode.next = new ListNode(node.val);
                curNode = curNode.next;
            }
        }

        return list.toArray(new ListNode[0]);
    }

}
