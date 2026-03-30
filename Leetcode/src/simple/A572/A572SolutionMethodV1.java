package simple.A572;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A572SolutionMethodV1  implements A572Solution{

    @Override
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        return check(root,subRoot) || isSubtree(root.left , subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean check(TreeNode right, TreeNode subRoot) {
        if(right == null && subRoot == null){
            return true;
        }
        if(right == null || subRoot == null || right.val != subRoot.val){
            return false;
        }
        return check(right.left, subRoot.left) && check(right.right, subRoot.right);
    }
}