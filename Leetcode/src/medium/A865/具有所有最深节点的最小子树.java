package medium.A865;

import javafx.util.Pair;

import java.util.Stack;

public class 具有所有最深节点的最小子树 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = createTree(nums);
        new 具有所有最深节点的最小子树().subtreeWithAllDeepest(root);
    }
    TreeNode res = null;
    Integer  max = -1;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        dfs(root, 0 );
        return res;
    }
    private int dfs(TreeNode root,int depth) {
        if(root == null) return depth;

        Integer left = dfs(root.left,depth+1);
        Integer right = dfs(root.right,depth+1);
        if(left == right && left >= max) {
            res = root;
            max = left;
            return left;
        }
        return Math.max(left, right);
    }


    private static TreeNode createTree(Integer[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(nums[0]);
        stack.push(root);
        for (int i = 1; i < nums.length; i++) {
            TreeNode node = stack.pop();
            Integer val = nums[i];
            if (val != null) {
                TreeNode left = new TreeNode(val);
                node.left = left;
                stack.push(left);
            }
            i ++;
            if(i < nums.length ){
                val = nums[i];
                if(val != null) {
                    TreeNode right = new TreeNode(val);
                    node.right = right;
                    stack.push(right);
                }
            }
        }
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
