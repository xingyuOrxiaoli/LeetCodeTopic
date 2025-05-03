package medium.A98;

import utils.TreeNode;

public class 验证二叉搜索树 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return checkBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean checkBST(TreeNode root , long min , long max) {
        if(root == null) return true;
        if (root.val <= min || root.val >= max)  return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}
