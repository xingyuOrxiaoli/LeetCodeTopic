package medium.A107;

import utils.TreeNode;

import java.util.*;

public class 二叉树的层序遍历II {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> level = new LinkedList<>();
        level.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer le = level.poll();
            if (le == res.size()) res.add(new ArrayList<>());
            res.get(le).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                level.offer(le + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(le + 1);
            }
        }
        int size = res.size();
        for (int i = 0; i < (size >> 1); i++) {
            List<Integer> list = res.get(i);
            res.set(i, res.get(size - i - 1));
            res.set(size - i - 1, list);
        }
        return res;
    }
    // 写法 2
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> level = new LinkedList<>();
        level.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer le = level.poll();
            if (le == res.size()) res.add(new ArrayList<>());
            res.get(le).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                level.offer(le + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(le + 1);
            }
        }

        Collections.reverse(res);
        return res;
    }

}
