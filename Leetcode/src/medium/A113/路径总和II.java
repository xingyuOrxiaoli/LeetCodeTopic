package medium.A113;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);

        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);

        List<List<Integer>> lists = new 路径总和II().pathSum(treeNode, 22);
        lists.forEach(System.out::println);
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,0 , targetSum,new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int curSum, int targetSum, ArrayList<Integer> path) {


        if (root == null || curSum > targetSum) return;

        curSum += root.val;
        path.add(root.val);
        if(curSum == targetSum && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            return;
        }
        if(root.left != null) {
            dfs(root.left, curSum, targetSum, path);
            path.remove(path.size() - 1);
        }
        if(root.right != null) {
            dfs(root.right, curSum, targetSum, path);
            path.remove(path.size() - 1);
        }
    }
}
