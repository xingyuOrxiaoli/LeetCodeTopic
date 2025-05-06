package medium.A103;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> level = new LinkedList<>();
        deque.push(root);
        level.push(0);
        boolean flag = true;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();

            int levelNum = level.pop();
            if(res.size() == levelNum) res.add(new LinkedList<>());

            Deque<Integer> list = (Deque<Integer>) res.get(levelNum);
            if((levelNum & 1) == 1) list.offerLast(node.val);
            else {
                list.offerFirst(node.val);
            }
            if(node.left != null) {
                deque.push(node.left);
                level.push(levelNum + 1);
            }
            if(node.right != null) {
                deque.push(node.right);
                level.push(levelNum + 1);
            }
        }
        return res;
    }
}
