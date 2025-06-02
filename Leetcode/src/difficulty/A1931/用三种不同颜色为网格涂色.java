package difficulty.A1931;


import java.util.*;

public class 用三种不同颜色为网格涂色 {

    public static void main(String[] args) {
        int i = new Solution().colorTheGrid(5, 5);
        System.out.println(i);
        int i1 = new 用三种不同颜色为网格涂色().colorTheGrid(5, 5);
        System.out.println(i1);
    }

    static final int mod = 1000000007;
    public int colorTheGrid(int m, int n) {

        // 所有可以选用的方案
        Map<Integer , List<Integer>> validity = new HashMap<>();
        for(int i = 0 ; i < Math.pow(3, m) ; i ++){
            int temp = i ,pre = -1 , cur = temp % 3;
            List<Integer> cases = new ArrayList<>();
            for(int j = 0 ; j < m ; j ++){
                if(cur == pre) break;
                pre = cur;
                cases.add(cur);
                temp /= 3;
                cur = temp % 3;
                if(cases.size() == m )  validity.put(i , cases);
            }
        }
        if(n == 1) return validity.size();

        // 方案能接受的下一个方案
        Map<Integer , List<Integer>> validity2 = new HashMap<>();
        validity.forEach((k1, v1) -> {
            validity.forEach((k2, v2) -> {
                if(k1 != k2){
                    for (int i = 0; i < v1.size(); i++) {
                        if(v1.get(i) == v2.get(i)) break;
                        if(i == v1.size() - 1){
                            if(validity2.get(k1) == null) validity2.put(k1 , new ArrayList<Integer>());
                            validity2.get(k1).add(k2);
                        }
                    }
                }
            });
        });

        // 初始化每一个方案的权重 假设只需要一种方案 也就是一列  则有validity中的key的总数
        Map<Integer , Integer> validity3 = new HashMap<>();
        for (Integer key : validity2.keySet()) {
            validity3.put(key, 1);
        }
//        validity2.forEach((key, value) -> validity3.put(key,1));
        // 从开始选第二列开始
        for(int i = 1 ; i < n ; i ++){
           Map<Integer,Integer> temp = new HashMap<>() , finalValidity = validity3;
            validity2.forEach((k2 , v2)->{
               v2.forEach(item->{
                   temp.put(k2, (finalValidity.getOrDefault(item,0) + temp.getOrDefault(k2,0) ) % mod);
               });
           });
           validity3 = temp;
        }
        int res = 0 ;
        for (Integer value : validity3.values()) {
            res = (res + value) % mod;
        }
        return res;
    }
}













class Solution {
    static final int mod = 1000000007;

    public int colorTheGrid(int m, int n) {
        // 哈希映射 valid 存储所有满足要求的对一行进行涂色的方案
        Map<Integer, List<Integer>> valid = new HashMap<>();
        // 在 [0, 3^m) 范围内枚举满足要求的 mask
        int maskEnd = (int) Math.pow(3, m);
        for (int mask = 0; mask < maskEnd; ++mask) {
            List<Integer> color = new ArrayList<>();
            int mm = mask;
            for (int i = 0; i < m; ++i) {
                color.add(mm % 3);
                mm /= 3;
            }
            boolean check = true;
            for (int i = 0; i < m - 1; ++i) {
                if (color.get(i).equals(color.get(i + 1))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                valid.put(mask, color);
            }
        }

        // 预处理所有的 (mask1, mask2) 二元组，满足 mask1 和 mask2 作为相邻行时，同一列上两个格子的颜色不同
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int mask1 : valid.keySet()) {
            for (int mask2 : valid.keySet()) {
                boolean check = true;
                for (int i = 0; i < m; ++i) {
                    if (valid.get(mask1).get(i).equals(valid.get(mask2).get(i))) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    adjacent.computeIfAbsent(mask1, k -> new ArrayList<>()).add(mask2);
                }
            }
        }

        Map<Integer, Integer> f = new HashMap<>();
        for (int mask : valid.keySet()) {
            f.put(mask, 1);
        }
        for (int i = 1; i < n; ++i) {
            Map<Integer, Integer> g = new HashMap<>();
            for (int mask2 : valid.keySet()) {
                for (int mask1 : adjacent.getOrDefault(mask2, new ArrayList<>())) {
                    g.put(mask2, (g.getOrDefault(mask2, 0) + f.getOrDefault(mask1, 0)) % mod);
                }
            }
            f = g;
        }

        int ans = 0;
        for (int num : f.values()) {
            ans = (ans + num) % mod;
        }
        return ans;
    }
}
