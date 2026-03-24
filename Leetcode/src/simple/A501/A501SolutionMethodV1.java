package simple.A501;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A501SolutionMethodV1  implements A501Solution{

    @Override
    public int[] findMode(TreeNode root) {

        List<Integer> counts = new ArrayList<>() , values = new ArrayList<>() , res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int pre = Integer.MIN_VALUE , count = 0 , max = 0;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }

            if(node.left == null && node.right == null){
                if(pre == Integer.MIN_VALUE) {
                    count = 1;
                    values.add(node.val);
                } else if(pre != node.val){
                    counts.add(count);
                    max = Math.max(max, count);
                    values.add(node.val);
                    count = 1;
                } else {
                    count++;
                }
                pre = node.val;
            } else {
                stack.push(node);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            if(stack.isEmpty()) {
                max = Math.max(max, count);
                counts.add(count);
            }
            node.left = null;
            node.right = null;
        }
        for(int i = 0; i < counts.size(); i++){
            if(counts.get(i) == max){
                res.add(values.get(i));
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}