package medium.A437;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和III {

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;

        int res =  dfs(root , targetSum);
        res += pathSum(root.left , targetSum);
        res += pathSum(root.right , targetSum);

        return res;
    }

    private int dfs(TreeNode root, long targetSum) {
        if(root == null) return 0;
        int res = 0;
        if(root.val == targetSum) res ++;

        res += dfs(root.left , targetSum - root.val);
        res += dfs(root.right , targetSum - root.val);
        return res;
    }

}
