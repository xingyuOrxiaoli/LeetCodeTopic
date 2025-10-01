package medium.A117;

import utils.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针II {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        Node connect = new 填充每个节点的下一个右侧节点指针II().connect(root);

    }

    // 空间复杂度O(N) 队列 层序遍历
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(1);
        int preLevel = 1;
        Node preNode = null;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            Integer curLevel = levels.poll();
            if (curNode.left != null) {
                queue.add(curNode.left);
                levels.add(curLevel + 1);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                levels.add(curLevel + 1);
            }

            if(curLevel == preLevel && preNode != null) {
                preNode.next = curNode;
            }
            preNode = curNode;
            preLevel = curLevel;
        }
        return root;
    }


}
// 方法二 使用递归 节省空间
// 空间复杂度O(N) 队列 层序遍历
class Solution {
    Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}
