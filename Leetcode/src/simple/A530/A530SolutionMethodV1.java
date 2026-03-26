package simple.A530;

import utils.TreeNode;

public class A530SolutionMethodV1  implements A530Solution{

    int res = Integer.MAX_VALUE;
    int pre = -100000;

    @Override
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        res = Math.min(res, Math.abs(root.val - pre));
        pre = root.val;
        dfs(root.right);
    }

}