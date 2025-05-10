package simple.A111;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度 {
    public static void main(String[] args) {

    }
    // 方法1
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE ;
        if(root.left != null) left= minDepth(root.left);
        if(root.right != null)  right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
    // 方法2 使用层序遍历
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> levels = new LinkedList<>();
        levels.add(0);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levels.poll();
            if(node.left == null && node.right == null && level != 0){
                return level + 1;
            }
            if(node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }
            if(node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }
        }
        return 1;
    }
}
