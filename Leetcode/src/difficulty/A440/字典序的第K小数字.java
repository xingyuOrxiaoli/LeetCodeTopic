package difficulty.A440;

public class 字典序的第K小数字 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int kthNumber = new 字典序的第K小数字().findKthNumber(681692778, 351251360);
        System.out.println(kthNumber  + "  416126219");
    }
    public int findKthNumber(int n, int k) {
        long res = 1;
        while( k > 1){
            int step = getSum(res , n);
            if(step < k){
                k -= step;
                res ++;
            }else{
                res *= 10;
                k --;
            }
        }
        return (int)res;
    }

    private int getSum(long res, int n) {
        int sum = 0 ;
        long floor = res;
        while(res <= n){
            sum += Math.min(floor, n ) - res + 1;
            res *= 10;
            floor = floor * 10 + 9;
        }
        return sum;
    }
}
