package medium.ALCR144;

import utils.TreeNode;

public class 翻转二叉树 {
    public static void main(String[] args) {

    }
    public TreeNode flipTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        flipTree(root.left);
        flipTree(root.right);
        return root;
    }
}
