package medium.A909;

import utils.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

public class 蛇梯棋 {
    public static void main(String[] args) {
        int[][] board = ArrayUtils.createArrayTwo("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]");
        int i = new 蛇梯棋().snakesAndLadders(board);
        System.out.println(i);
    }
    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        Queue<Integer> queue = new LinkedList<>() , levels = new LinkedList<>();
        queue.add(0);
        levels.add(0);
        while (!queue.isEmpty()) {
            int now = queue.poll() , level = levels.poll();
            for(int i = 1 ; i <= 6 ; i ++){
                
            }


        }

        return -1;
    }
}
