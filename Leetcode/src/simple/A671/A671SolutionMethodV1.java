package simple.A671;

import utils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class A671SolutionMethodV1  implements A671Solution{

    @Override
    public int findSecondMinimumValue(TreeNode root) {
        int first = root.val , preLevel = 0 ;
        long second = Long.MAX_VALUE;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        q.offer(root);
        levels.offer(0);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            Integer level = levels.poll();

            if(preLevel != level ) {
                if(second != Integer.MAX_VALUE) {
                    return (int) second;
                }
                preLevel = level;
            }

            if(first != node.val) {
                second = Math.min(second, node.val);
            }
            if(node.left != null) {
                q.offer(node.left);
                levels.offer(level);
            }
            if(node.right != null) {
                q.offer(node.right);
                levels.offer(level);
            }
        }

        return second != Long.MAX_VALUE? (int) second : -1;
    }
}