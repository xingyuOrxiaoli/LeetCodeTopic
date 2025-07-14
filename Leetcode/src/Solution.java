import utils.ArrayUtils;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] arrayTwo = ArrayUtils.createArrayTwo("[[0,1],[1,2]]");
        int i = new Solution().maxLen(3, arrayTwo, "aba");
        System.out.println(i);
    }
    public String processStr(String s) {
        StringBuilder res =  new StringBuilder();
        int n  = s.length();
        for(int i  = 0 ;i <  n ; i ++){
            if(s.charAt(i) == '*'){
                if(res.length() > 0){
                    res.deleteCharAt(res.length()-1);
                }
            }else if(s.charAt(i) == '#'){
                res.append(res.toString());
            }else if(s.charAt(i) == '%'){
                res.reverse();
            }else res.append(s.charAt(i));
        }

        return res.toString();
    }

    public int minCost(int n, int[][] edges, int k) {
        int res = 0 , count = n , index =  0 ;
        int[] parent = new int[n ];
        for(int i = 0 ; i < n ; i ++) parent[i] = i;
        Arrays.sort(edges,(a,b) -> a[2] - b[2]);

        while(count != k){
            int x = edges[index][0] , y = edges[index][1];
            int x_p = find(x, parent) , y_p = find(y, parent);
            int p = Math.min(x_p, y_p);
            y_p = Math.max(y_p, x_p);
            if(p != y_p){
                count --;
                parent[y] = p;
                parent[x] = p;
                parent[p] = p;
                parent[y_p] = p;
            }
            res = edges[index][2];
            index ++;
        }
        return res;
    }
    private int find(int x , int[] parent){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }


    public char processStr(String s, long k) {
        String s1 = processStr(s);
        if(s1.length() >= k) return s1.charAt((int) k);
        return '.';
    }

    int[][] eds = new int[14][14];
    int[] indexs = new int[14];
    int res = 1;
    boolean[][] visited = new boolean[1 << 14][14];  // visited[mask][last_node]

    public int maxLen(int n, int[][] edges, String label) {
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            eds[u][indexs[u]++] = v;
            eds[v][indexs[v]++] = u;
        }

        for (int i = 0; i < n; i++) {
            List<Character> path = new ArrayList<>();
            path.add(label.charAt(i));
            dfs(i, 1 << i, path, label);
        }

        return res;
    }

    private void dfs(int u, int mask, List<Character> path, String label) {
        if (visited[mask][u]) return;
        visited[mask][u] = true;

        if (isValid(path)) res = Math.max(res, path.size());

        for (int i = 0; i < indexs[u]; i++) {
            int v = eds[u][i];
            if ((mask & (1 << v)) == 0) {
                path.add(label.charAt(v));
                dfs(v, mask | (1 << v), path, label);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(List<Character> path) {
        int l = 0, r = path.size() - 1;
        while (l < r) {
            if (!path.get(l).equals(path.get(r))) return false;
            l++; r--;
        }
        return true;
    }
}