package medium.A904;

import utils.ArrayUtils;

public class 水果成篮 {
    public static void main(String[] args) {
        int res = new 水果成篮().totalFruit(ArrayUtils.createArrayOne("[3,3,3,1,2,1,1,2,3,3,4]"));
        System.out.println(res);
    }
    public int totalFruit(int[] fruits) {
        int res = 0 , left = 0 , n = fruits.length , count = 0 ;
        int[] counts = new int[n];
        for(int i = 0 ; i < n ; i++){
            counts[fruits[i]] ++;
            if(counts[fruits[i]] == 1) count ++;
            if(count == 3){
                res = Math.max(res, i - left);
                while(count != 2){
                    counts[fruits[left]] --;
                    if(counts[fruits[left++]] == 0) count --;
                }
            }
        }
        res = Math.max(res, n - left);
        return res;
    }
}
