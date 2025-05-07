package medium.A105;

import utils.ArrayUtils;
import utils.TreeNode;

public class 从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {

        int[] preorder = ArrayUtils.createArrayOne("[3,9,20,15,7]");
        int[] inorder = ArrayUtils.createArrayOne("[9,3,15,20,7]");
        TreeNode treeNode = new 从前序与中序遍历序列构造二叉树().buildTree(preorder, inorder);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1,root);
        return root;
    }
    private void buildTree(int[] preorder, int[] inorder, int preStart,int preEnd  ,int inStart, int inEnd  ,TreeNode root) {
        if(preStart ==  preEnd) return;
        int val = root.val;

        int inRootIndex = inStart;
        while(inorder[inRootIndex] != val) inRootIndex++;
        int dist = inRootIndex - inStart;
        if(dist != 0){
            // 有左孩子
            root.left = new TreeNode(preorder[preStart + 1]);
            buildTree(preorder,inorder,preStart + 1 , preStart + dist,inStart,inRootIndex - 1,root.left);
        }
//        dist = inEnd - inRootIndex;
        if(preStart + dist + 1 <= preEnd){
            // 有右孩子
            root.right = new TreeNode(preorder[preStart + dist + 1]);
            buildTree(preorder,inorder,preStart + dist + 1 , preEnd,inRootIndex + 1 ,inEnd,root.right);
        }
    }
}
