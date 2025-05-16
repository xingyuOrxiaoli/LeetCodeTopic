package medium.A116;

import utils.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {

    }

    // 方法1 队列 层序遍历
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pre = null;
            for(int i = 0 ; i < level ; i ++){
                Node node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
//                if(i + 1 == level) break;
                if(pre != null){
                    pre.next = node;
                }
                pre = node;
            }
            level <<= 1;
        }
        return root;
    }

    // 方法2 递归
    public Node connect2 (Node root) {
        if (root == null) return null;
        if (root.left == null) return root;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        connect2(root.left);
        connect2(root.right);
        return root;
    }
}
