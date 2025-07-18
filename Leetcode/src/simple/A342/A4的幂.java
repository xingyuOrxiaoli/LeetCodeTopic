package simple.A342;

public class A4的幂 {

    public boolean isPowerOfFour(int n) {

        if(n == 0) return false;
        while(n != 1){
            if((n & 3) != 0) return false;
            n >>= 2;
        }
        return true;
    }
}
