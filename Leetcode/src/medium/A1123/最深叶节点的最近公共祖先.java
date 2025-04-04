package medium.A1123;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 最深叶节点的最近公共祖先 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = createTree(nums);
         new 最深叶节点的最近公共祖先().lcaDeepestLeaves(root);
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

    public TreeNode lcaDeepestLeaves(TreeNode root) {

        Pair<TreeNode, Integer> dfs = dfs(root);
        return dfs.getKey();
    }
    private Pair<TreeNode,Integer> dfs(TreeNode root) {
        if(root == null) return new Pair(root,0);

        Pair<TreeNode,Integer> left = dfs(root.left);
        Pair<TreeNode,Integer> right = dfs(root.right);

        Integer leftValue = left.getValue();
        Integer rightValue = right.getValue();
        if (leftValue == rightValue){
            return new Pair(root,leftValue + 1);
        }
        if(leftValue > rightValue) {
            return new Pair(left.getKey(),leftValue + 1);
        }else {
            return new Pair(right.getKey(),rightValue + 1);
        }
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