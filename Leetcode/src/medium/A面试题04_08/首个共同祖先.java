package medium.A面试题04_08;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 首个共同祖先 {


    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root , p , q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        boolean left = dfs(root.left , p , q);
        boolean right = dfs(root.right , p , q);
        if((left && right) || ((root == p || root == q) && (left || right))){
            res = root;
        }

        return left || right || root == p || root == q;

    }


}
