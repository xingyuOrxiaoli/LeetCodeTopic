package simple.A面试题04_02;

import utils.TreeNode;

public class 最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length ;

        return dfs(0, n - 1, nums);
    }

    private TreeNode dfs(int l, int r, int[] nums) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(l , mid-1, nums);
        root.right = dfs(mid + 1, r, nums);
        return root;
    }
}
