package simple.A104;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {

    public static void main(String[] args) {

    }
    // 方法一 使用层次遍历
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(1);
        int res = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levels.poll();
            res = Math.max(res, level);
            if(node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }
            if(node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }
        }

        return res;
    }
}
