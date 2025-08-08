package simple.A258;

public class 各位相加 {
    public static void main(String[] args) {
        int i = new 各位相加().addDigits(38);
        System.out.println(i);
    }
    public int addDigits(int num) {
        int res = num ;
        while(res >=10){
            res = 0;
            while(num != 0){
                res += num % 10;
                num /= 10;
            }
            num = res;
        }
        return res;
    }
}
