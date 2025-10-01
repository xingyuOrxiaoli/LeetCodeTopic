package simple.A面试题04_04;

import utils.TreeNode;

public class 检查平衡性 {

    boolean res = true;
    public boolean isBalanced(TreeNode root) {

        treeHeight(root);

        return res;
    }

    private int treeHeight(TreeNode root) {
        if (root == null && res) return 0;
        int left = 0 , right = 0;
        if(root.left != null){
            left = treeHeight(root.left) + 1;
        }
        if(root.right != null){
            right = treeHeight(root.right) + 1;
        }
        if(Math.abs(left - right) > 1){
            res = false;
        }
        return Math.max(left, right);
    }

}
