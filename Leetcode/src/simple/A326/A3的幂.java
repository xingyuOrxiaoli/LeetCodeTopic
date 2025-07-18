package simple.A326;

public class A3的幂 {
    public static void main(String[] args) {
        boolean powerOfThree = new A3的幂().isPowerOfThree(27);
        System.out.println(powerOfThree);
    }

    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n < 3) return false;
        while(n != 1){
            if(n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }
}
