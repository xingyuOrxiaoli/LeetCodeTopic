package medium.A236;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {

    }

    // 方式一
    HashMap<Integer,TreeNode> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    private void dfs(TreeNode root) {
        if(root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p != null){
            set.add(p.val);
            p = map.get(p.val);
        }

        while(q != null){
            if(set.contains(q.val)){
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    // 方式二
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}
