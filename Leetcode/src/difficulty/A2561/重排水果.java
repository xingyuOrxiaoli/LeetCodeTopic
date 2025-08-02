package difficulty.A2561;

import utils.ArrayUtils;

import java.util.*;

public class 重排水果 {
    public static void main(String[] args) {
        long res = new 重排水果().minCost(ArrayUtils.createArrayOne("[84,80,43,8,80,88,43,14,100,88]"), ArrayUtils.createArrayOne("[32,32,42,68,68,100,42,84,14,8]"));
        System.out.println(res);
    }
    public long minCost(int[] basket1, int[] basket2) {
        long res= 0;
        int n = basket1.length , count  = 0 , min = Integer.MAX_VALUE;
        TreeMap<Integer,Integer> map1 = new TreeMap<>() , map2 = new TreeMap<>() ;
        for(int i =0  ; i < n ; i ++) {
            map1.put(basket1[i], map1.getOrDefault(basket1[i], 0) + 1);
            min = Math.min(min, basket1[i]);
        }
        for(int i = 0 ; i < n ; i ++){
            if(map1.containsKey(basket2[i])){
                if (map1.get(basket2[i]) == 1) map1.remove(basket2[i]);
                else map1.put(basket2[i] , map1.get(basket2[i]) - 1);
            }else map2.put(basket2[i],map2.getOrDefault(basket2[i] , 0) + 1);
            min = Math.min(min, basket2[i]);
        }
        min <<= 1;
        for (Integer value : map1.values())
            if((value & 1) == 0) count += value >> 1;
            else return -1;
        for(Integer value : map2.values())
            if((value & 1) == 1) return  -1;
        while(count != 0){
            int key1 = map1.firstKey() , key2 = map2.firstKey();
            int value1 = map1.get(key1) , value2 = map2.get(key2);
            if(key1 > key2){
                if(value2 == 2) map2.remove(key2);
                else map2.put(key2 , value2 - 2);
            }else{
                if(value1 == 2) map1.remove(key1);
                else map1.put(key1 , value1 - 2);
            }
            res += Math.min(min , Math.min(key1, key2));
            count --;
        }
        return res;
    }
}
