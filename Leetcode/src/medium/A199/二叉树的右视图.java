package medium.A199;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图 {
    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levels.poll();

            while(!queue.isEmpty() && level == levels.peek()){
                if(node.left != null) {
                    queue.add(node.left);
                    levels.add(level + 1);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    levels.add(level+1);
                }

                node = queue.poll();
                level = levels.poll();
            }
            res.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }
            if(node.right != null) {
                queue.add(node.right);
                levels.add(level+1);
            }
        }
        return res;
    }
}
