package medium.A106;

import utils.ArrayUtils;
import utils.TreeNode;

public class 从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] postorder = ArrayUtils.createArrayOne("[2,1]");
        int[] inorder = ArrayUtils.createArrayOne("[2,1]");
        TreeNode treeNode = new 从中序与后序遍历序列构造二叉树().buildTree(postorder,inorder);


    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        buildTree(postorder,inorder , 0,inorder.length - 1,0,postorder.length - 1,root);
        return root;
    }
    private void buildTree(int[] postorder,int[] inorder,  int postStart,int postEnd  ,int inStart, int inEnd  ,TreeNode root) {
        if(postStart ==  postEnd) return;
        int val = root.val;

        int inRootIndex = inStart;
        while(inorder[inRootIndex] != val) inRootIndex++;
        int dist = inEnd - inRootIndex;
        if(postEnd - dist - 1 >= postStart){
            // 有左孩子
            root.left = new TreeNode(postorder[postEnd - dist - 1]);
            buildTree(postorder,inorder,postStart , postEnd - dist - 1 ,inStart,inRootIndex - 1,root.left);
        }
//        dist = inEnd - inRootIndex;
        if(postEnd  - 1 > postEnd - dist - 1){
            // 有右孩子
            root.right = new TreeNode(postorder[postEnd - 1]);
            buildTree(postorder,inorder,postEnd - dist, postEnd - 1,inRootIndex + 1 ,inEnd,root.right);
        }
    }
}
