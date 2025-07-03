package difficulty.A233;

public class 数字1的个数 {
    public static void main(String[] args) {

    }
    public int countDigitOne(int n) {
        int res = 0;
        long temp = 1;
        while(temp <= n){
            res += (n / (temp * 10)) * temp  + Math.min(temp , Math.max(n % (temp * 10) - temp + 1 , 0));
            temp *= 10;
        }
        return res;
    }

}
