package medium.A869;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 重新排序得到2的幂 {

    public static void main(String[] args) {
        boolean res = new 重新排序得到2的幂().reorderedPowerOf2(10);
        System.out.println(res);
    }
    boolean[] visited = new boolean[10];
    List<Integer> list = new ArrayList<>(16);
    public boolean reorderedPowerOf2(int n) {
        while(n != 0){
            list.add(n % 10);
            n /= 10;
        }
        n = list.size();
        long temp = 0 ;
        int u = 0 ;
        for(int i = 0 ; i < n; i++)
            if(list.get(i) != 0) {
                visited[i] = true;
                if (dfs(temp + list.get(i) , u + 1 , n) ) return true;
                visited[i] = false;
            }
        return false;
    }

    private boolean dfs(long temp, int u, int n) {
        if(u == n) return isCheck(temp);

        boolean res = false;
        for(int i = 0 ; i < n && !res; i++)
            if(!visited[i]) {
                visited[i] = true;
                res |= dfs(temp * 10 + list.get(i), u + 1, n);
                visited[i] = false;
            }

        return res;
    }

    private boolean isCheck(long temp) {
        boolean res = true;
        while(temp != 0){
            if((temp & 1) == 1){
                if(!res) return false;
                res = false;
            }
            temp >>= 1;
        }

        return true;
    }

}
