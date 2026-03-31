package simple.A653;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A653SolutionMethodV1  implements A653Solution{

    private final List<Integer> list = new ArrayList<>();
    @Override
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int left = 0 , right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if(sum == k) {
                return true;
            } else if(sum < k) {
                left ++;
            } else {
                right --;
            }
        }

        return false;
    }

    private void dfs(TreeNode root) {

        if(root.left != null){
            dfs(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            dfs(root.right);
        }
    }
}