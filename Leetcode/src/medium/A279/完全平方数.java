package medium.A279;

public class 完全平方数 {
    public static void main(String[] args) {
        int i = new 完全平方数().numSquares(12);
        System.out.println(i);
    }
    public int numSquares(int n) {
        int res = 0 ;
        while(n != 0){
            long cur = 1;
            while( cur * cur <= n){
                cur ++;
            }
            res ++;
            n -= cur * cur;
        }
        return res;
    }
}
