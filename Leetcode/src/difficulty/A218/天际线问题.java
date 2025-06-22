package difficulty.A218;

import java.util.*;

public class 天际线问题 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> positions = new ArrayList<>();
        for (int[] building : buildings) {
            int x = building[0] , y = building[1] , z = building[2];
            positions.add(new int[]{x,-z});
            positions.add(new int[]{y,z});
        }
        Collections.sort(positions, (a , b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        Map<Integer,Integer> deleted = new HashMap<>();
        PriorityQueue<Integer> heights = new PriorityQueue<>((a , b ) -> b - a);
        int preHeight = 0;
        heights.add(preHeight);

        for (int[] position : positions) {
            int x = position[0] , z = position[1];
            if(z < 0){
                heights.add(- z);
            }else{
                deleted.put(z,deleted.getOrDefault(z,0) + 1);
            }
            int curHeight = heights.peek();
            while(!heights.isEmpty()){
                curHeight= heights.peek();
                if(deleted.containsKey(curHeight)){
                    int delete = deleted.get(curHeight);
                    if(delete == 1) deleted.remove(curHeight);
                    else deleted.put(curHeight,delete - 1);
                    heights.poll();
                }else break;
            }
            if(preHeight != curHeight){
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(curHeight);
                res.add(temp);
                preHeight = curHeight;
            }

        }
        return res;
    }
}
