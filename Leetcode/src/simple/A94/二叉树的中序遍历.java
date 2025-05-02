package simple.A94;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

    public static void main(String[] args) {

    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;

        // 左边
        inorderTraversal(root.left);
        // 中
        res.add(root.val);

        // 右
        inorderTraversal(root.right);
        return res;
    }
}
