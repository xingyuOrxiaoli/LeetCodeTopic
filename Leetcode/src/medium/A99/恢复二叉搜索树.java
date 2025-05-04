package medium.A99;

import utils.TreeNode;

public class 恢复二叉搜索树 {
    public static void main(String[] args) {

    }

    // 借助中序遍历  + 数组
    int[] arr = new int[1000];
    int index = 0 , i = -1 ;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int left =  -1 , right = -1;

        for(int i = 1 ; i < index ; i++){
            if(left == -1 && arr[i - 1] > arr[i]) left = i - 1;
            else if(arr[i - 1] > arr[i]){
                right = i;
                break;
            }
        }
        if(right == -1) right = left + 1;
        // System.out.println(left);
        // System.out.println(right);
        // System.out.println(Arrays.toString(arr));
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[right] ^ arr[left];
        arr[left] = arr[left] ^ arr[right];
        // System.out.println(Arrays.toString(arr));
        i = 0 ;
        dfs(root);
    }
    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        if(i == -1) arr[index++] = root.val;
        else root.val = arr[i++];
        dfs(root.right);
    }

    // 尝试优化  -> 空间 O(1)
    public void recoverTree1(TreeNode root) {
        dfs(root,false,null,Long.MAX_VALUE);
    }
    // dfs
    public void dfs(TreeNode root, boolean flag, TreeNode maxNode, long maxVal) {
        if (root == null || flag) return;
        dfs(root.left, flag,maxNode,maxVal);
        if(maxVal != Long.MAX_VALUE && maxVal > root.val && (root.right != null && root.right.val > maxVal)){
            maxNode.val = root.val;
            root.val = (int)maxVal;
            flag = true;
        }
        if(maxVal == Long.MAX_VALUE || maxVal < root.val) {
            maxNode = root;
            maxVal = root.val;
        }
        maxNode.val = Math.max(maxNode.val,root.val);
        System.out.println(root.val +"  " + maxNode.val);
        dfs(root.right, flag, maxNode,maxVal);
    }
}
