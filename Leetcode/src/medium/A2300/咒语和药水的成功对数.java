package medium.A2300;

import java.util.Arrays;

public class 咒语和药水的成功对数 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length , m = potions.length , left = 0  , right = m - 1;
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++){
            left = 0 ;
            right = m - 1 ;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if((long)spells[i] * potions[mid] < success) left = mid + 1;
                else right = mid - 1;
            }
//            System.out.println(left + ":" + right);
            res[i] = m - left;
        }
        return res;
    }
}
