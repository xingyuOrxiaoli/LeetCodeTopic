package simple.A222;

import utils.TreeNode;

public class 完全二叉树的节点个数 {
    public static void main(String[] args) {

    }
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
