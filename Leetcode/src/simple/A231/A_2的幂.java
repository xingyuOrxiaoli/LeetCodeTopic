package simple.A231;

public class A_2的幂 {
    public static void main(String[] args) {
        boolean powerOfTwo = new A_2的幂().isPowerOfTwo(0);
        System.out.println(powerOfTwo);
    }
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        int sum = 0 ;
        while(n != 0 ){
            sum  += n & 1;
            if(sum == 2) return false ;
            n >>= 1;
        }
        return true;
    }
}
