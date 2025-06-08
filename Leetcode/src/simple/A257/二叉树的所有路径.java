package simple.A257;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> res = new 二叉树的所有路径().binaryTreePaths(root);
        System.out.println(res);
    }

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, ArrayList<Integer> path) {
        if(root.left == null && root.right == null) {

            StringBuilder temp = new StringBuilder();
            for (Integer node : path) {
                temp.append(node);
                temp.append("->");
            }
            temp.append(root.val);
            res.add(temp.toString());
            path.add(root.val);
            return;
        }

        path.add(root.val);
        if(root.left != null) {
            dfs(root.left,path);
            path.remove(path.size()-1);
        }
        if(root.right != null) {
//            path.add(root.val);
            dfs(root.right,path);
            path.remove(path.size()-1);
        }
    }
}
