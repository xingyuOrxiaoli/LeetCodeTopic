package simple.A226;

import utils.TreeNode;

public class 翻转二叉树 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
