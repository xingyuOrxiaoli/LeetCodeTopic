package medium.A235;

import utils.TreeNode;

public class 二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);

        if(root.val < p.val) return lowestCommonAncestor(root.right, p, q);
        else if(root.val > q.val) return lowestCommonAncestor(root.left, p, q);

        return root;
    }
}
