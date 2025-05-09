package simple.A110;

import utils.TreeNode;

public class 平衡二叉树 {


    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) > -1;
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == - 1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

}
