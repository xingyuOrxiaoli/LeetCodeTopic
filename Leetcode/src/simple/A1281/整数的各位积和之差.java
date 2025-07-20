package simple.A1281;

public class 整数的各位积和之差 {
    public int subtractProductAndSum(int n) {
        int sum1 = 1 , sum2 = 0 ;
        while(n != 0){
            sum1 *= n % 10;
            sum2 += n % 10;
            n /= 10;
        }
        return sum1 - sum2;
    }
}
