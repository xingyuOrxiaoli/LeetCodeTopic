package simple.A263;

public class 丑数 {
    public static void main(String[] args) {

    }
    public boolean isUgly(int n) {
        if(n == 0) return false;
        while(n % 2 == 0){
            n /= 2;
        }
        while(n % 5 == 0){
            n /= 5;
        }
        while(n % 3 == 0){
            n /= 3;
        }


        return n == 1;
    }
}
