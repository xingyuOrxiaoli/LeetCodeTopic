package medium.A50;

public class Pow_x_n_ {
    public static void main(String[] args) {
        double v = new Pow_x_n_().myPow(2.0, 1);
//        System.out.println(Math.pow(1.1 , Integer.MAX_VALUE));
        System.out.println(Math.pow(1.1 , Integer.MIN_VALUE));
        new Pow_x_n_().myPow(2.0, Integer.MIN_VALUE);
        System.out.println(v);
    }
    public double myPow(double x, int n) {
        long i = n;
        if(i < 0) i = -i;
        double res = 1.0;
        while(i > 0) {
            if( (i & 1) == 1) res *= x;
            x *= x;
            i = i >> 1;
        }

        if(n < 0 ) res = 1.0 / res;
        return res;
    }
}
