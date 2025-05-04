package simple.A100;

import utils.TreeNode;

public class 相同的树 {

    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = true;
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;
        if(p.val != q.val) return false;
        res = res && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return res;
    }
}
