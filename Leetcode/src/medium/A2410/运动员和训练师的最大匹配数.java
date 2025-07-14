package medium.A2410;

import java.util.Arrays;

public class 运动员和训练师的最大匹配数 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int res = 0 , n = players.length , m = trainers.length , i = 0 , j = 0 ;
        while (i < n && j < m) {
            if (players[i] <= trainers[j]) {
                res ++;
                i ++;
                j ++;
            }else j ++;
        }

        return res;
    }
}
