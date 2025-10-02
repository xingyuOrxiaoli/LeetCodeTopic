package medium.A面试题04_06;

import utils.TreeNode;

public class 后继者 {
    TreeNode res;
    boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root , p);
        return res;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if(root == null || res != null) return;
        dfs(root.left , p);
        if(flag == true){
            res = root;
        }
        flag = p == root;
        dfs(root.right , p);
    }
}
