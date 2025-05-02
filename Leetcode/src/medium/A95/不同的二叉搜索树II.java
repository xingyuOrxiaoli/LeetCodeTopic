package medium.A95;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树II {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = new 不同的二叉搜索树II().generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode.val);
        }
    }
    public List<TreeNode> generateTrees(int n) {
        return createTreeNode(1,n);
    }
    private List<TreeNode> createTreeNode(int start,int end){

        List<TreeNode> res = new ArrayList<>();
        for(int i = start ; i <= end ; i++){

            List<TreeNode> lefts = createTreeNode(start, i-1);
            List<TreeNode> rights = createTreeNode(i + 1, end);
            if(lefts.size() > 0 && rights.size() > 0){
                for(int left = 0 ; left < lefts.size() ; left++){
                    for(int right = 0 ; right < rights.size() ; right++){
                        TreeNode root = new TreeNode(i);
                        root.left = lefts.get(left);
                        root.right = rights.get(right);
                        res.add(root);
                    }
                }
            }else if(lefts.size() > 0){
                for(int left = 0 ; left < lefts.size() ; left++){
                    TreeNode root = new TreeNode(i);
                    root.right = null;
                    root.left = lefts.get(left);
                    res.add(root);
                }
            }else if(rights.size() > 0){
                for(int right= 0 ; right < rights.size() ; right++){
                    TreeNode root = new TreeNode(i);
                    root.left = null;
                    root.right = rights.get(right);
                    res.add(root);
                }
            }else {
                res.add(new TreeNode(i));
            }
        }
        return res;
    }
}
