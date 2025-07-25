package medium.A1423;

public class 可获得的最大点数 {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0 , n = cardPoints.length , sum = 0;
        for(int i = 0 ; i < k ; i ++ ) sum += cardPoints[i];
        res = sum;
        for(int i  = -1 ; i >= -k ; i --){
            sum -= cardPoints[k + i];
            sum += cardPoints[n + i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
