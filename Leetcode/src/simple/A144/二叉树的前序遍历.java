package simple.A144;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {
    public static void main(String[] args) {

    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
