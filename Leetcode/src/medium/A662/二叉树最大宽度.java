package medium.A662;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0 ;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexs = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        queue.offer(root);
        indexs.offer(0);
        levels.offer(1);
        while(!queue.isEmpty()){
            int start_index = indexs.peek();
            int level = levels.peek();
            int end_index = start_index;
            while(!queue.isEmpty() && level == levels.peek()){

                TreeNode cur = queue.poll();
                end_index = indexs.poll();
                // System.out.println(level  + "=" +levels.peek()+"="+ start_index +"=" + end_index);
                int t_level = levels.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                    levels.offer(t_level + 1);
                    indexs.offer((end_index * 2));
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    levels.offer(t_level + 1);
                    if(end_index * 2 < 0 ) {
                        start_index = 1 ;
                        end_index = 1;
                        indexs.offer(1);
                    }
                    else indexs.offer((end_index * 2) + 1);
                }
            }
            res = Math.max(res , end_index - start_index + 1);
            // System.out.println(res);
        }

        return res;
    }
}
