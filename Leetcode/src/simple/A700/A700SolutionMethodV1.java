package simple.A700;

import utils.TreeNode;

public class A700SolutionMethodV1  implements A700Solution{

    @Override
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) {
            return null;
        }
        if(root.val==val) {
            return root;
        }else if(root.val > val) {
            return searchBST(root.left, val);
        } else{
            return searchBST(root.right, val);
        }

    }
}