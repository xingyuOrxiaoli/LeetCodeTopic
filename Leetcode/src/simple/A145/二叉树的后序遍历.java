package simple.A145;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历 {
    public static void main(String[] args) {

    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return res;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
