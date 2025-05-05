package simple.A101;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 对称二叉树 {

    public static void main(String[] args) {
        int[] arr = {3003, 2002, 3004, 1001, 3004, 2002, 3003};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(list);
        boolean check = new 对称二叉树().check(list,1001);
        System.out.println(check);
    }

    // 迭代
    List<Integer> list = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        root.val = 1;
        dfs(root,1000);
        System.out.println(list);
        return list.size() == 0 || check(list,root.val + 1000);
    }
    private void dfs(TreeNode root,int w) {
        if (root == null){
            list.add(-101);
            return;
        }
        if(root.left != null || root.right != null){
            // if(root.left != null ) root.left.val += 101;
            dfs(root.left,w + 1000);
        }
        list.add(root.val + w);
        if(root.left != null || root.right != null) dfs(root.right , w + 1000);
    }
    private boolean check(List<Integer> list , int rootVal){
        int n = list.size() , mid = n >> 1 ;
        if(list.get(mid) != rootVal || (n & 1) == 0) return false;
        for(int i = 0 ;i < mid ; i ++){
            int left =  list.get(mid - i - 1) , right = list.get(mid + i + 1) ;
            if(left != right) return false;
        }
        return true;
    }

}
