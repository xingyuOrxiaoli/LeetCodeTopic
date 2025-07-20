package simple.A2236;

import utils.TreeNode;

public class 判断根结点是否等于子结点之和 {
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int left = root.left == null ? 0 : root.left.val , right = root.right == null ? 0 : root.right.val;
        if(root.val != left + right) return false;
        return checkTree(root.left) && checkTree(root.right);
    }
}
