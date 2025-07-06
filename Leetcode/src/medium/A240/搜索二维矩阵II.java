package medium.A240;

import java.util.*;

public class 搜索二维矩阵II {
    public static void main(String[] args) {
        new 搜索二维矩阵II().minCost(2,3,new int[][]{{6,1,4},{3,2,5}});
    }
    // 暴力
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length , m  = matrix[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length , m  = matrix[0].length , x = n - 1 , y =  0 ;
        while (x > - 1 && y  < m ){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] < target) y ++;
            else x -- ;
        }
        return false;
    }

    public String concatHex36(int n) {
        StringBuilder res = new StringBuilder();


        int n1 = n * n *  n;
        // 三十六进制
        while(n1 != 0){
            int t = n1 % 36;
            if(t < 10) res.insert(0,t);
            else res.insert(0,(char)(t - 10 + 'A'));
            n1 /= 36;
        }

        // 十六进制
        int n2 = n *  n;
        while(n2 != 0){
            int t = n2 % 16;
            if(t < 10) res.insert(0,t);
            else res.insert(0,(char)(t - 10 + 'A'));
            n2 /= 16;
        }
        return res.toString();
    }


    public long minCost(int m, int n, int[][] waitCost) {

        for(int i = 0 ; i < m ; i++){
            int x = (i + 1);
            for(int j = 0 ; j < n ; j++){
                int val = x * (j + 1);
                if(i == m - 1 && j == n - 1 ) waitCost[i][j] = val;
                else waitCost[i][j] += val;
            }
        }
        long[][] dp = new long[m][n];
        // waitCost  等待价值
        // 等待价值 + 进入成本
        // 进入成本 与 i j 无关
        // 最后的点位只有进入价值  只能向下 / 向右 - > 不断靠近
        // dp[i][j] = min(dp[i-1][j] , dp[i][j-1])

        dp[0][0] = 1;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0) dp[i][j] = dp[i][j - 1] + waitCost[i][j];
                else if(j == 0) dp[i][j] = dp[i - 1][j] + waitCost[i][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + waitCost[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minTime(int n, int[][] edges)  {
        // edges[i] = [ui, vi, starti, endi] \
        // t  走一步算 1  个时间单位  拓扑排序   进入最小  计时器检查
        // bfs
        // dfs
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>())
                    .add(new int[]{e[1], e[2], e[3]});
        }

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], u = curr[1];

            if (u == n - 1) return time;

            if (time > minTime[u]) continue;

            List<int[]> list = graph.getOrDefault(u, Collections.emptyList());
            for (int[] e : list) {
                int v = e[0], start = e[1], end = e[2];

                if (time > end) continue;

                int nextTime = Math.max(time, start) + 1;

                if (nextTime < minTime[v]) {
                    minTime[v] = nextTime;
                    pq.offer(new int[]{nextTime, v});
                }
            }
        }
        return -1;
    }
    public int minStable(int[] nums, int maxC) {
        // 所有元素的最大公因数 大于或等于 2  -> 优化 ： 欧拉定理 ？？
        // 子数组的长度
        // 最多 可以修改数组中的 maxC 个元素为任意整数
        // maxC 个修改为    最大公因数
        // 如果 数据中存在 超过 maxC  优化 ： 欧拉定理 ？？  这个地方公共部分只有一个1和一个2 的重复部分数的个
        int[][] dp = new int[nums.length][1];
        for (int i = 0; i < nums.length; i++) dp[i][0] = nums[i];

        int n = nums.length ,  left = 1, right = n, res = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAchieve(nums, maxC, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean canAchieve(int[] nums, int maxC, int limit) {
        int n = nums.length , count = 0 ,  left = 0 , right = 0 ,  cur = nums[0];

        while (right < n) {
            cur = nums[right];
            for (int i = right - 1; i >= left; i--) {
                cur = gcd(cur, nums[i]);
                if (cur == 1) break;
            }
            while (cur >= 2 && right - left + 1 > limit) {
                count++;
                left = right;
                cur = nums[right];
            }
            right++;
        }
        return count <= maxC;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
