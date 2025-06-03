package difficulty.A1298;

import utils.ArrayUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 你能从盒子里获得的最大糖果数 {
    public static void main(String[] args) {
        int[] status = ArrayUtils.createArrayOne("[1,0,1,0]");
        int[] candies = ArrayUtils.createArrayOne("[7,5,4,100]");

        int[][] keys = ArrayUtils.createArrayTwo("[[],[],[1],[]]");
        int[][] containedBoxes = ArrayUtils.createArrayTwo("[[1,2],[3],[],[]]");

        int[] initialBoxes = ArrayUtils.createArrayOne("[0]");

        int i = new 你能从盒子里获得的最大糖果数().maxCandies(status, candies, keys, containedBoxes, initialBoxes);
        System.out.println(i);
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int  res = 0 , n = status.length;
        boolean[] visited = new boolean[n] , box = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int initialBox : initialBoxes) {
            box[initialBox] = true;
            if(status[initialBox] == 1){
                queue.add(initialBox);
                visited[initialBox] = true;
                res += candies[initialBox];
            }
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for (int key : keys[temp]) {
                status[key] = 1;
                if(!visited[key] && box[key]){
                    queue.add(key);
                    visited[key] = true;
                    res += candies[key];
                }
            }
            for (int containedBox : containedBoxes[temp]) {
                box[containedBox] = true;
                if(!visited[containedBox] && status[containedBox] == 1){
                    queue.add(containedBox);
                    visited[containedBox] = true;
                    res += candies[containedBox];
                }
            }
        }
        return res;
    }
}
