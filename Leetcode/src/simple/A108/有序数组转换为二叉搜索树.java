package simple.A108;

import utils.TreeNode;

public class 有序数组转换为二叉搜索树 {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0 , right = nums.length - 1 , mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left ,mid - 1);
        root.right = dfs(nums,mid + 1,right);
        return root;
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if(left > right) return null;
        int mid = (left + right) >> 1;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = dfs(nums,left,mid - 1);
        res.right = dfs(nums,mid + 1,right);
        return res;
    }
}
