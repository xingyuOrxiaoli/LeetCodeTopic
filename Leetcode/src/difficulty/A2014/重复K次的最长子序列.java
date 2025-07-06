package difficulty.A2014;

import java.util.*;

public class 重复K次的最长子序列 {
    public static void main(String[] args) {
        List<String> strings = new 重复K次的最长子序列().validateCoupons(new String[]{"SAVE20", "", "PHARMA5", "SAVE@20"}, new String[]{"restaurant", "grocery", "pharmacy", "restaurant"}, new boolean[]{true, true, true, true});
        System.out.println(strings);
    }

    char[] res ;
    int resLen;
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[chs                                                                                                  [i] - 'a']++;
        }
        StringBuilder temp = new StringBuilder();
        for(int i = 25 ; i > -1 ; i --){
            String str = (char)('a' + i) +"";
            for(int j = 0 ; j < counts[i] / k ; j ++){
                temp.append(str);
            }
        }
        char[] t = temp.toString().toCharArray();

        res = new char[t.length];

        permute(t,k,chs);

        return "";
    }

    // 全排列
    // 枚举从nums中选任意个数的所有排列
    private void permute(char[] nums, int k, char[] chs) {
        int n = nums.length;
        char[] path = new char[n];
        boolean[] visited = new boolean[n];
        dfs(0 , nums,path,visited,k ,chs);
    }

    private void dfs(int index, char[] nums, char[] path, boolean[] visited, int k, char[] chs) {

        if(index == nums.length) return;

//        for()


    }


    class Temp implements Comparable<Temp> {
        int businessLine;
        String code;

        public Temp(int businessLine, String code) {
            this.businessLine = businessLine;
            this.code = code;
        }
        @Override
        public int compareTo(Temp o) {
            if(this.businessLine != o.businessLine) return this.businessLine - o.businessLine;
            return this.code.compareTo(o.code);
        }
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        //code[i]：一个 字符串，表示优惠券的标识符。
        // businessLine[i]：一个 字符串，表示优惠券所属的业务类别。
        // isActive[i]：一个 布尔值，表示优惠券是否当前有效。

        // code[i] 不能为空，并且仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）组成。
        // businessLine[i] 必须是以下四个类别之一："electronics"、"grocery"、"pharmacy"、"restaurant"。
        // isActive[i] 为 true 。

        // electronics 4  grocery 3  pharmacy 2  restaurant 1

        // 先按照其 businessLine 的顺序排序："electronics"、"grocery"、"pharmacy"、"restaurant"。
        // 在每个类别内，再按照 标识符的字典序（升序）排序。
        List<String> res = new ArrayList<>() ;
        List<Temp> kind = new ArrayList<>() ;
        String[] businessLines = new String[]{"restaurant","pharmacy" ,"grocery","electronics"};
        int n = code.length;
        for(int i = 0 ; i < n ; i++){
            if(isActive[i] && checkCode(code[i])){
                for (int j = 0; j < businessLines.length; j++) {
                    if(businessLines[j].equals(businessLine[i])){
                        kind.add(new Temp(j,code[j]));
                        continue;
                    }
                }
            }
        }

        Collections.sort(kind);
        kind.forEach(value -> res.add(value.code));


        return res;
    }

    private boolean checkCode(String s) {
        int n = s.length();
        if(n == 0) return false;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if((ch >= '0' && ch <= '9') || (ch >='a' && ch <= 'z') || (ch >='A' && ch <= 'Z') || ch == '_')continue;
            return false;
        }
        return true;
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // connections 边

        // queries
        //  同一电网中编号最小的在线电站解决
        // [2, x]：电站 x 离线（即变为非运行状态）。

        // 并查集   连通  非联通
        // 1 <= c <= 105
        // 0 <= n == connections.length <= min(105, c * (c - 1) / 2) ->
        // 1 <= queries.length <= 2 * 105  -》 查询O(1)

        int[] p = new int[c + 1];
        for(int i = 1 ; i <=c ; i ++) p[i] = i;
        for (int[] conn : connections) init(p, conn[0], conn[1]);

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find(p, i);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }
        boolean[] visited = new boolean[c + 1];
        Arrays.fill(visited, true);
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0], x = query[1];
            int root = find(p, x);

            if (type == 1) {
                if (visited[x]) {
                    res.add(x);
                } else {
                    TreeSet<Integer> set = map.get(root);
                    if (set == null || set.isEmpty()) {
                        res.add(-1);
                    } else {
                        res.add(set.first());
                    }
                }
            } else if (type == 2) {
                if (visited[x]) {
                    visited[x] = false;
                    TreeSet<Integer> set = map.get(root);
                    if (set != null) {
                        set.remove(x);
                    }
                }
            }
        }


     return res.stream().mapToInt(i -> i).toArray();
    }

    private void init(int[] p, int x, int y) {
        int px = find(p , x) , py = find(p , y);
        if(px != py) p[px] = py;
    }

    private int find(int[] p, int c) {
        if(p[c] != c) p[c] = find(p ,p[c]);
        return p[c];
    }

    public int minTime(int n, int[][] edges, int k) {
        // 拓扑  ？？
        // 1 <= n <= 105
        // 0 <= edges.length <= 105
        // 最多加几条边   -> 稀疏图  按照最大边一个一个的加
        // 最小联通图的反
        Arrays.sort(edges , (a , b) -> b[2] - a[2]);
        int[] p = new int[n] , score = new int[n];
        for(int i = 0 ; i < n ; i ++) p[i] = i;

        int count = n  , m = edges.length , index = 0 ;
        for(int i = 0 ; i < m ; i ++){
            int x = edges[i][0] , y = edges[i][1];
            int px = find(p , x) , py = find(p , y);
            if(px != py){
                count -- ;
                p[px] = py;
            }
            if(count < k) {
                return edges[i][2];
            }
        }
        return 0;
    }

    public int minMoves(int sx, int sy, int tx, int ty) {
        //  如果无法到达目标点，则返回 -1。
        // 保证 x y 最后几次 越来越大
        // 0 <= sy <= ty <= 109
        // x tx - sx
        // y ty - sy
        // dp[i][j] = dp[x + m][y] || dp[x][y + m]
        // m = Math.max(x , y);
        int n = tx - sx + 1, m = ty - sy + 1;
        if(n == 1 && m == 1) return 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(dp[i][j] == 0) continue;
                int step = Math.max(sx + i , sy + j);
                if(i + step < n) dp[i + step][j] = dp[i][j] + 1;
                if(j + step < m) dp[i][j + step] = dp[i][j] + 1;
            }
        }
        return dp[n - 1][m - 1] - 1;
    }
}
