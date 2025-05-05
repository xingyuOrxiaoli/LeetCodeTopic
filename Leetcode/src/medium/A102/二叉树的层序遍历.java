package medium.A102;

import utils.TreeNode;

import java.util.*;

public class 二叉树的层序遍历 {

    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)  return res;
        Queue<TreeNode> queue = new LinkedList<>() ;
        Queue<Integer> floors  = new ArrayDeque<>();
        queue.add(root);
        floors.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int floor = floors.poll();
            if(res.size() != floor) res.add(new ArrayList<>());
            res.get(floor - 1).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                floors.add(floor + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                floors.add(floor + 1);
            }
        }
        return res;
    }

}
