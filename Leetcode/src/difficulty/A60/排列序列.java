package difficulty.A60;

import java.util.Arrays;

public class 排列序列 {
    public static void main(String[] args) {

        for(int n = 1 ; n <= 9 ; n ++){
            for(int k = 1 ; k <= get(n) ; k++){
                // 1,2,6,24,120,720,5040,40320,362880
                String permutation = new 排列序列().getPermutation(n , k );
                String permutation1 = new Solution().getPermutation(n, k);
                if(permutation.equals(permutation1)){
                    System.out.println("[INFO] 通过测试用例: n = " + n + ", k = " + k );
                }else{
                    System.out.println("[WARN] 未通过测试用例: n = " + n + ", k = " + k  + ", 你的算法结果：" + permutation + ", 答案为： " + permutation1);
                    return;
                }
            }
        }
        System.out.println("[INFO] 通过所有案例" );
    }
    public String getPermutation(int n, int k) {
        int[] st = {0,1,2,6,24,120,720,5040,40320,362880};
        StringBuilder num = new StringBuilder("123456789") , res = new StringBuilder();
        for(int i = 1 ; i <n ; i++){
            // 求第i的数
            int valueIndex = (k  - 1) / st[n - i];
            res.append(num.charAt(valueIndex));
            num.deleteCharAt(valueIndex);
            k -= valueIndex * st[n - i];
        }
        res.append(num.charAt(0));
        return res.toString();
    }
    public  static int get(int n ){
        int res = 1;
        for(int i = 2 ; i <= n ; i ++) res *=i;
        return res;
    }
}
// LeetCode 官方题解
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
