package simple.A617;

import utils.TreeNode;

public class A617SolutionMethodV1  implements A617Solution{

    @Override
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        } else if(root2 == null){
            return root1;
        }
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}