package simple.A559;

import utils.Node;

import java.util.LinkedList;
import java.util.Queue;

public class A559SolutionMethodV1  implements A559Solution{

    @Override
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int res = 0;
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        q.offer(root);
        levels.offer(1);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            Integer level = levels.poll();
            res = Math.max(res, level);
            for (Node child : cur.children) {
                if(child != null) {
                    q.offer(child);
                    levels.offer(level + 1);
                }
            }
        }
        return res;
    }
}