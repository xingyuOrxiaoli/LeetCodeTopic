package medium.A173;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树迭代器 {
}
class BSTIterator {

    private List<Integer> list = new ArrayList<>();
    private int index = 0 ;
    public BSTIterator(TreeNode root) {
        this.dfs(root);
    }

    public int next() {
        return list.get(this.index++);
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public boolean hasNext() {
        return this.index != list.size();
    }
}