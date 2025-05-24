package difficulty.A124;

import utils.TreeNode;

public class 二叉树中的最大路径和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);

        int i = new 二叉树中的最大路径和().maxPathSum(root);
        System.out.println(i);
    }
    Integer res = -1000010;
    public int maxPathSum(TreeNode root) {
        // System.out.println(res);
        maxPath(root);

        return res;
    }
    public int maxPath(TreeNode root) {
        if(root == null) return 0;

        int left  = Math.max(maxPath(root.left) , 0 );
        int right = Math.max(maxPath(root.right), 0 );

        // System.out.println(res + " === " + (left + right + root.val));
        res = Math.max(res, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
