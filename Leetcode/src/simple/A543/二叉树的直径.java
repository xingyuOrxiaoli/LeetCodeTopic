package simple.A543;

import utils.TreeNode;

public class 二叉树的直径 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int temp = right + left + 1;
        res = Math.max(res, temp);
        return Math.max(left, right) + 1;
    }
}
