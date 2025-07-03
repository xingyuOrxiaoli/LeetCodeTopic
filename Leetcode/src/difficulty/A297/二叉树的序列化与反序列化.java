package difficulty.A297;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
        String serialize = new 二叉树的序列化与反序列化().serialize(root);
        System.out.println(serialize);
    }
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res =  new StringBuilder();
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levels.poll();
            if(node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
                depth = Math.max(depth, level + 1);
            }
            if(node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
                depth = Math.max(depth, level + 1);
            }
        }
        queue.add(root);
        levels.add(1);

        int nullCount = 0 ;
        res.append("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null ) {
                nullCount --;
                if(nullCount != queue.size()) {
                    res.append("null,");
                }
                else break;
                continue;
            }
            Integer level = levels.poll();
            res.append(node.val +",");
            if(node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }else {
                if(depth > level ) {
                    queue.add(null);
                    nullCount ++;
                }
            }
            if(node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }else{
                if(depth > level ) {
                    queue.add(null);
                    nullCount ++;
                }
            }
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)) return null;
        // System.out.println(data);
        String[] split = data.substring(1, data.length() - 1).split(",");
        // System.out.println(split.length);

        Integer value = Integer.valueOf(split[0]);
        TreeNode root = new TreeNode(value);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < split.length; i+=2) {
            TreeNode node = queue.poll();
            if(!"null".equals(split[i])) {
                value = Integer.valueOf(split[i]);
                node.left = new TreeNode(value);
                queue.add(node.left);
            }
            if(i + 1 < split.length) {
                if(!"null".equals(split[i + 1])) {
                    value = Integer.valueOf(split[i + 1]);
                    node.right = new TreeNode(value);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
