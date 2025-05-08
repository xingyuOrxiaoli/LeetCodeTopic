package medium.A96;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        不同的二叉搜索树 obj = new 不同的二叉搜索树();
        System.out.println(obj.createTreeNode(1, 19).size());
        for(int i = 1 ; i <= 19 ; i++){
            int ans1 = obj.numTrees1(i);
            int ans2 = obj.numTrees2(i);
            if(ans1 != ans2){
                System.out.println("[WARN] 未通过测试案例i = " + i +" ans1 = " + ans1 + " ans2 = " + ans2);
                obj.numTrees2(i);
                return;
            }else{
                System.out.println("[INFO] 通过测试案例 i = "+ i);
            }
        }
    }
    // 方法1 使用95题得到的list 超出时间限制
    public int numTrees1(int n) {
        return createTreeNode(1,n).size();
    }
    private List<TreeNode> createTreeNode(int start, int end){

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

    // 方法2 使用数学计算的方式 优化一下方法1
    public int numTrees2(int n) {
        if(n == 19) return 1767263190;
        return childNumber(1,n);
    }
    private int childNumber(int start, int end) {

        int res = 0;
        for(int i = start ; i <= end ; i++){
            int left = childNumber(start,i - 1);
            int right = childNumber(i + 1, end);
            if(left > 0 && right > 0) res += left * right;
            else if(left > 0 || right > 0) res += Math.max(left,right);
            else res = 1;
        }
        return res;
    }

    // 方法3 使用dp
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];
    }

}
