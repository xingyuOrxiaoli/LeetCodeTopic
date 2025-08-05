package simple.A3477;

public class 水果成篮II {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length ,  res = n;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(!visited[j] && fruits[i] <= baskets[j]){
                    visited[j] = true;
                    res --;
                    break;
                }
            }
        }

        return res;
    }
}
