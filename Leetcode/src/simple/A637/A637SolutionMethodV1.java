package simple.A637;

import utils.TreeNode;

import java.util.*;

public class A637SolutionMethodV1  implements A637Solution{

    @Override
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        int preLevel = 0 ;
        double sum = 0 , num = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        queue.offer(root);
        levels.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levels.poll();
            if(level == preLevel) {
                sum += node.val;
                num ++;
            } else {
                res.add(sum / num);
                preLevel = level;
                num = 1;
                sum = node.val;
            }

            if (node.left != null) {
                queue.offer(node.left);
                levels.offer(level+1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                levels.offer(level+1);
            }
        }
        res.add((sum / num));

        return res;
    }
}