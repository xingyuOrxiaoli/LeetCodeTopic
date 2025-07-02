package medium.A230;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉搜索树中第K小的元素 {
    public static void main(String[] args) {

    }

    // 方法一
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k --;
            if(k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }

}
