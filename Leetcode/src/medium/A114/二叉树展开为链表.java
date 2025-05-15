package medium.A114;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树展开为链表 {

    public static void main(String[] args) {

    }

    // 空间复杂度O(N)
    List<Integer> print = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        dfs(root);
        TreeNode temp = root;
        for (int i = 0 ; i < print.size() - 1 ; i++) {
            temp.val = print.get(i);
            temp.left = null;
            if(temp.right == null) temp.right = new TreeNode();
            temp = temp.right;
        }
        temp.val = print.get(print.size() - 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        print.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
