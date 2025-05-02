package utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode createTreNode(String text){
        TreeNode root = new TreeNode();
        String[] split = text.substring(1, text.length() - 1).split(",");
        Deque<TreeNode> que = new ArrayDeque<>();
        que.addLast(root);
        int t = 0 ;
        while (t < split.length){
            TreeNode node = que.pop();
            Integer val  = Integer.valueOf(split[t]);
            // 左
            if(t * 2 + 1 < split.length && null == Integer.valueOf(split[t * 2 + 1])) node.left = null;
            // 右
        }
        return root;
    }
}
