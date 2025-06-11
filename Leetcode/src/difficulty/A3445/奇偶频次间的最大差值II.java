package difficulty.A3445;

public class 奇偶频次间的最大差值II {
    public static void main(String[] args) {
        int i = new 奇偶频次间的最大差值II().maxDifference("2222130", 2);
        System.out.println(i);
    }
    public int maxDifference(String s, int k) {
        int n = s.length();
        int[][] dict = new int[n + 1][5];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                dict[i][j] = dict[i - 1][j];
            }
            dict[i][s.charAt(i - 1) - '0'] ++;
        }
        int INF = 300000;
        int res = -INF;
        for(int i = 0 ; i < 5 ; i ++){
            for(int j = 0 ; j < 5 ; j ++){
                if(i == j) continue;
                int[][] status = {{INF,INF} , {INF,INF}};
                int left = 0 , right = 1 ;

                while(right <= n ){

                    while(right - left >= k && dict[right][i] > dict[left][i] && dict[right][j] > dict[left][j]){

                        int x = dict[left][i] & 1;
                        int y = dict[left][j] & 1;
                        status[x][y] = Math.min(status[x][y], dict[left][i] - dict[left][j]);

                        left ++;
                    }
                    res = Math.max(res , dict[right][i] - dict[right][j] - status[dict[right][i] & 1 ^ 1][dict[right][j]& 1]);
                    right ++;
                }
            }
        }

        return res;
    }
    public int maxDifference1(String s, int k) {
        int n = s.length() , res = Integer.MIN_VALUE;
        int[][] dict = new int[n][5];
        dict[0][s.charAt(0) - '0']++;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                dict[i][j] = dict[i - 1][j];
            }
            dict[i][s.charAt(i) - '0'] ++;
        }
        int sum ;
        for(int i = 0 ; i <= n - k  ; i ++){

            for(int j = i + k; j <= n ; j ++){
                int odd = 0 , even = Integer.MAX_VALUE;
                for(int y = 0 ; y < 5 ; y ++){
                    sum = dict[j - 1][y];
                    if(i != 0 ) sum -= dict[i - 1][y];
                    if((sum & 1) == 0 && sum != 0) even = Math.min(even, sum);
                    else odd = Math.max(odd, sum);
                }
                if(odd == 0 || even == 0) continue;
                res = Math.max(res , odd - even);
            }
        }
        return res;
    }
}
