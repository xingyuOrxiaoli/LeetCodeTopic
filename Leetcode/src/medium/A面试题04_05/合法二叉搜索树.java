package medium.A面试题04_05;

import utils.TreeNode;

public class 合法二叉搜索树 {

    int cur = 0 , index = 0;
    boolean res  = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (!res  || root == null) return;
        dfs(root.left );
        if(index == 0){
            cur = root.val ;
            index = -1;
        }else{
            if(root.val <= cur) {
                res = false;
                return;
            }
            cur = root.val ;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}
