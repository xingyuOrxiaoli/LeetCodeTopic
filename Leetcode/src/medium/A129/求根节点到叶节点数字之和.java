package medium.A129;

import utils.TreeNode;

public class 求根节点到叶节点数字之和 {
    public static void main(String[] args) {
        int i = new 求根节点到叶节点数字之和().sumNumbers(null);
        System.out.println(i);
    }

    int res = 0 ;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int value) {
        if(root.left == null && root.right == null) {
            res += value * 10 + root.val;
            return;
        }
        value = value * 10 + root.val;
        if(root.left != null) dfs(root.left,value);
        if(root.right != null) dfs(root.right,value);
    }
}
