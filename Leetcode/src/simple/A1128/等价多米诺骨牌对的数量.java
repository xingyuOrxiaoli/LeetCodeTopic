package simple.A1128;

import java.util.*;

public class 等价多米诺骨牌对的数量 {

    public static void main(String[] args) {
        int[][] dominoes = {
                {1,2},
                {1,2},
                {1,1},
                {1,2},
                {2,2}
        };
        int i = new 等价多米诺骨牌对的数量().numEquivDominoPairs(dominoes);
        System.out.println(i);
    }

    // 方法1 字符串+map计数
    public int numEquivDominoPairs1(int[][] dominoes) {
        int min  = Math.min(dominoes[0][0],dominoes[0][1]) , max = Math.max(dominoes[0][0],dominoes[0][1]) ;
        Map<String,Integer> map = new HashMap();
        map.put(min +""+ max,1);
        int res = 0;
        for(int i = 1;i<dominoes.length;i++){
            min  = Math.min(dominoes[i][0],dominoes[i][1]) ;
            max  = Math.max(dominoes[i][0],dominoes[i][1]) ;
            String key = min +""+ max;
            res += map.getOrDefault(key,0);
            map.put(key,map.getOrDefault(key,0) + 1);
        }
        return res;
    }
    // 数组
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] dict = new int[100];
        int res = 0;
        for(int i = 0;i<dominoes.length;i++){
            int index = dominoes[i][0] * 10 + dominoes[i][1];
            res += dict[index];
            dict[index] ++;
            if(dominoes[i][0] != dominoes[i][1]) {
                index = dominoes[i][1] * 10 + dominoes[i][0];
                res += dict[index];
            }
        }
        return res;
    }
}
