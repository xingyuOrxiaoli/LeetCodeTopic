package medium.A面试题04_05;

import utils.TreeNode;

public class 合法二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int cur = root.val;
        if(root.left != null && root.left.val > cur || root.right != null && root.right.val < cur){
            return false;
        }
        return isValidBST(root.left , root.val , 0 ) && isValidBST(root.right , root.val , 1);
    }
    private boolean isValidBST(TreeNode root, int parentValue , int status) {
        if(root == null) return true;
        int cur = root.val ;
        if(root.left != null){
            int left = root.left.val ;
            if(left >= cur){
                return false;
            }
            if(status == 0 && left >= parentValue){
                return false;
            }
            if(status == 1 && left <= parentValue){
                return false;
            }
        }
        if(root.right != null){
            int right = root.right.val ;
            if(right <= cur){
                return false;
            }
            if(status == 0 && right >= parentValue){
                return false;
            }
            if(status == 1 && right <= parentValue){
                return false;
            }
        }

        return isValidBST(root.left , root.val  , 0) && isValidBST(root.right , root.val  , 1);
    }
    public static void main(String[] args) {

    }
}
