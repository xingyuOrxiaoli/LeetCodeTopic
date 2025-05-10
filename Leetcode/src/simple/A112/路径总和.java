package simple.A112;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 路径总和 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null){
                node.left.val += node.val;
                queue.offer(node.left);
            }
            if(node.right != null){
                node.right.val += node.val;
                queue.offer(node.right);
            }
            if(node.left == null && node.right == null && node.val == targetSum) return true;
        }
        return false;
    }

    // 方法2 使用dfs
    boolean res = false;
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    private void dfs(TreeNode root, int sum) {
        if(root == null || res) return;
        if(root.left == null && root.right == null &&root.val == sum){
            res = true;
            return;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }

}
