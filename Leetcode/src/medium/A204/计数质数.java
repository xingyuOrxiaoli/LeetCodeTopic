package medium.A204;

public class 计数质数 {
    public static void main(String[] args) {
        int i = new 计数质数().countPrimes(10);
        System.out.println(i);
    }

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int res = 0;
        for(int i = 2 ;i  < n ; i++){
            if(!primes[i]){
                res ++;
                for(long j = i * 2 ; j < n ; j += i){
                    primes[(int) j] = true;
                }
            }
        }
        return res;
    }

    public int countPrimes1(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                res ++;
            }
        }
        return res;
    }
    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
