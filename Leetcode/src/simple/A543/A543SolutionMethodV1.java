package simple.A543;

import utils.TreeNode;

public class A543SolutionMethodV1  implements A543Solution{

    int res = 0;
    @Override
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int temp = right + left;
        res = Math.max(res, temp);
        return Math.max(left, right) + 1;
    }
}