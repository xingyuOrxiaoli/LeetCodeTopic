package simple.A572;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A572SolutionMethodV2 implements A572Solution{

    private List<Integer> r = new ArrayList<>();
    private List<Integer> s = new ArrayList<>();

    private Integer maxElement ;
    private Integer lNull;
    private Integer rNull;

    @Override
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }

        maxElement = Integer.MIN_VALUE;
        getMaxElement(root);
        getMaxElement(subRoot);

        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(root,r);
        getDfsOrder(subRoot,s);


        return kmp();
    }

    private void getDfsOrder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        if(root.left != null) {
            getDfsOrder(root.left, list);
        } else {
            list.add(lNull);
        }

        if(root.right != null) {
            getDfsOrder(root.right, list);
        }else {
            list.add(rNull);
        }
    }

    private void getMaxElement(TreeNode root) {
        if(root == null){
            return;
        }
        maxElement = Math.max(maxElement, root.val);
        getMaxElement(root.left);
        getMaxElement(root.right);
    }

    // TODO 背诵 默写模板
    private boolean kmp() {
        int m = r.size() , n = s.size();
        int[] fail = new int[n];
        Arrays.fill(fail , -1);
        for(int i = 1 , j = -1; i < n ; i++) {
            while (j != -1 && !(s.get(i).equals(s.get(j + 1)))) {
                j = fail[j];
            }
            if(s.get(i).equals(s.get(j + 1))) {
                j ++;
            }
            fail[i] = j;
        }

        for(int i = 0 , j = -1; i < m ; i ++) {
            while (j != -1 && !(r.get(i).equals(s.get(j + 1)))) {
                j = fail[j];
            }
            if(r.get(i).equals(s.get(j + 1))) {
                j ++;
            }
            if(j == n - 1) {
                return true;
            }
        }
        return false;
    }
}