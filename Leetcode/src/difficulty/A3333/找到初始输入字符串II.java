package difficulty.A3333;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class 找到初始输入字符串II {
    public static void main(String[] args) {
       for(int i = 0 ; i < 10000; i ++){
            System.out.print('a');
       }
        for(int i = 0 ; i < 10000; i ++){
            System.out.print('b');
        }
        for(int i = 0 ; i < 10000; i ++){
            System.out.print('c');
        }
        for(int i = 0 ; i < 10000; i ++){
            System.out.print('a');
        }
        for(int i = 0 ; i < 10000; i ++){
            System.out.print('b');
        }
        for(int i = 0 ; i < 10000; i ++){
            System.out.print('b');
        }
        for(int i = 0 ; i < 10000; i ++){
            System.out.print('a');
        }
        System.out.println();

        int i = new 找到初始输入字符串II().possibleStringCount("aabbccdd", 7);

        System.out.println(i);
    }



    int mod = 1000000007;
    public int possibleStringCount(String word, int k) {
        int n = word.length()  ,left = 0 , count = 1;
        List<Integer> list = new ArrayList<>();
        // 对其
        list.add(1);
        // 统计数量
        for(int i = 1 ; i < n ; i ++){
            if(word.charAt(i) == word.charAt(left)) count++;
            else{
                list.add(count);
                count = 1;
                left = i;
            }
        }
        list.add(count);
        long res = 1;
        for (Integer value : list) res = res * value % mod;
        int m = list.size();
        if(m > k) return (int) res;
        int[][] dp = new int[m][k];
        int[] temp = new int[k]; // 存放 每一次的方案数量
        // 当 方案的字符串长度为0的时候，我们这里开端的时候对齐了，索引表示用了几段输入的字符串，
        // 初始阶段，当使用第一段的时候 并且满足dp[1][x - 1] x满足 x >= list.get(1) -> 表示 如果使用第1段的时候 方案数量是 上一段满足大于 k - list.get(1)的数量就可以了
        //

        // 初始化边界值
        Arrays.fill(dp[0], 1);

        for(int i = 1; i < m; i ++){
            for(int j = 1 ; j < k ; j ++){
                // 当目前长度为 j的时候
                // 使用新的段 那么至少使用一次 那么 长度为j的时候可能满足的方案为 上一段 长度 j - 1 所有方案之和 有长度 1 2 ... j - 1
                temp[j] = dp[i - 1][j - 1] ;


                if(j - list.get(i) - 1 >= 0){
                    // 筛掉temp[j]方案中长度 不可能满足长度为 j的方案
                    temp[j] = (temp[j] - dp[i - 1][j - list.get(i) - 1] + mod) % mod;
                }
            }

            // 求前缀和
            dp[i][0] = temp[0];
            for(int x = 1 ; x < k ; x ++) dp[i][x] =( dp[i][x - 1] + temp[x]) % mod;

        }

        // 全部方案的数量  - 不可能满足条件方案的数量
        return (int)((res - dp[m - 1][k - 1] + mod) % mod);
    }

    // 超时
    int ans = 0 ;
    public int possibleStringCount1(String word, int k) {
        int n = word.length() , left = 0  , res = 0 ,baseLen = 1;
        if(n == k) return 1;
        List<Integer> list = new ArrayList<>();
        // 数字的分布
        for(int i = 1; i < n ; i ++){
            if(word.charAt(i) == word.charAt(left)) res ++;
            else {
                baseLen ++;
                if(res != 0) list.add(res);
                res = 0;
                left = i;
            }
        }
        if(res != 0 ) list.add(res);
        int other = k - baseLen;
//        System.out.println(list);

        dfs(list,0,other);

        return ans;
    }

    private void dfs(List<Integer> list, int index, int other) {

        if(other <= 0){
            long temp = 1;
            for(int i = index ; i < list.size() ; i ++){
                temp *= (list.get(i) + 1);
                temp %= mod;
            }
            ans %= mod;
            ans += temp;
            return;
        }
        if(index == list.size() ){
            if(other <= 0) {
                ans++;
                ans %= mod;
            }
            return;
        }
        int nums = list.get(index);

        for(int i = nums ; i > -1 ; i --){
            dfs(list , index + 1 , other - i);
        }
    }




}
class Solution {
    private static final int mod = 1000000007;

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        int cnt = 1;
        List<Integer> freq = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ++cnt;
            } else {
                freq.add(cnt);
                cnt = 1;
            }
        }
        freq.add(cnt);

        long ans = 1;
        for (int o : freq) {
            ans = ans * o % mod;
        }
        if (freq.size() >= k) {
            return (int) ans;
        }

        int[] g = new int[k];
        Arrays.fill(g, 1);
        for (int i = 0; i < freq.size(); ++i) {
            int[] f_new = new int[k];
            for (int j = 1; j < k   ; ++j) {
                f_new[j] = g[j - 1];
                if (j - freq.get(i) - 1 >= 0) {
                    f_new[j] = (f_new[j] - g[j - freq.get(i) - 1] + mod) % mod;
                }
            }
            int[] g_new = new int[k];
            g_new[0] = f_new[0];
            for (int j = 1; j < k; ++j) {
                g_new[j] = (g_new[j - 1] + f_new[j]) % mod;
            }
//            f = f_new;
            g = g_new;
        }

        return (int) ((ans - g[k - 1] + mod) % mod);
    }
}