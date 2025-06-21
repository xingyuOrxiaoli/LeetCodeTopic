package medium.A3443;

public class K次修改后的最大曼哈顿距离 {
    public static void main(String[] args) {
        int i = new K次修改后的最大曼哈顿距离().maxDistance("SN",0);
        System.out.println(i);
    }
    public int maxDistance(String s, int k) {
        int nc = 0 , sc = 0 , ec = 0 , wc = 0  , res  = 0 , n = s.length();
        for(int i = 0 ; i < n ; i++){
            char temp = s.charAt(i);
            switch (temp){
                case 'N':
                    nc ++;
                    break;
                case 'S':
                    sc ++;
                    break;
                case 'E':
                    ec ++;
                    break;
                case 'W':
                    wc ++;
                    break;
            }
            int sum = 0;
            if(nc > sc){
                if(ec > wc){
                    sum = sc + wc;
                    if(sum > k) res = Math.max(res, nc + ec + k - sum + k);
                    else res = Math.max(res, nc + ec + sum);
                }else{
                    sum = sc + ec;
                    if(sum > k) res = Math.max(res, nc + wc + k - sum + k);
                    else res = Math.max(res, nc + wc + sum);
                }
            }else{
                if(ec > wc){
                    sum = nc + wc;
                    if(sum > k) res = Math.max(res, sc + ec + k - sum + k);
                    else res = Math.max(res, sc + ec + sum);
                }else{
                    sum = nc + ec;
                    if(sum > k) res = Math.max(res, sc + wc + k - sum + k);
                    else res = Math.max(res, sc + wc + sum);
                }
            }
        }
        return res;
    }
}
