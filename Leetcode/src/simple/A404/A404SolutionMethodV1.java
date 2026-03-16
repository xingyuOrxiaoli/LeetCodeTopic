package simple.A404;

import utils.TreeNode;

public class A404SolutionMethodV1 implements A404Solution{
    @Override
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 0;
        }
        return dfs(root,false);
    }

    private int dfs(TreeNode root , boolean isLeft) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        int res = 0;
        if(root.left != null) {
            res += dfs(root.left,true);
        }

        if(root.right != null) {
            res += dfs(root.right,false);
        }

        return res;
    }
}
