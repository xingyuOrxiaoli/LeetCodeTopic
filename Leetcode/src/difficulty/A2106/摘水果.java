package difficulty.A2106;

import utils.ArrayUtils;

public class 摘水果 {
    public static void main(String[] args) {
        int res = new 摘水果().maxTotalFruits(ArrayUtils.createArrayTwo("[[0,7],[7,4],[9,10],[12,6],[14,8],[16,5],[17,8],[19,4],[20,1],[21,3],[24,3],[25,3],[26,1],[28,10],[30,9],[31,6],[32,1],[37,5],[40,9]]"),
                21, 30);
        System.out.println(res);
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length , res = 0 , down = startPos - k  ,up = startPos + k , right = 0;
        long[] sum = new long[n + 1];
        boolean flag = true;
        for(int i = 0 ; i < n ; i ++) {
            if(fruits[i][0] <= startPos) right ++;
            sum[i + 1] = sum[i] + fruits[i][1];
        }
        int left = 0;
        for(int i = 0 ; i < n ; i ++) {
            if(fruits[i][0] < down) continue;
            else if(fruits[i][0] > up) break;

            int t ;
            if(startPos > fruits[i][0]) {
                t = k - startPos + fruits[i][0] * 2;
                while(right < n && fruits[right][0] <= t) right++;
                res = Math.max(res, (int)(sum[right] - sum[i]));
            }else {
                if(flag){
                    while(right < n && fruits[right][0] <= up)  right++;
                    res = Math.max(res, (int)(sum[right] - sum[i]));
                    flag = false;
                }
                // 探测左边
                t = fruits[i][0] * 2 - k- startPos;
                while(fruits[left][0] < t) left ++ ;
                res = Math.max(res, (int)(sum[i + 1] - sum[left]));
            }
        }

        return res;
    }
}
