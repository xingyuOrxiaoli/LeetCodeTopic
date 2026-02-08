package medium.A1488;

import java.util.*;

public class 避免洪水泛滥 {


    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res ,  -1);
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(rains[i] == 0){
                queue.offer(i);
                res[i] = 1;
                continue;
            }
            if(map.containsKey(rains[i]) && map.get(rains[i]) > queue.peek()){
                if(queue.isEmpty()){
                    return new int[0];
                }
                res[queue.poll()] = rains[i];
            }
            map.put(rains[i], i);
        }
        return res;
    }

}
