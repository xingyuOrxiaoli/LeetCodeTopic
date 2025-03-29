package simple.A2614;

public class 对角线上的质数 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,2,3},
                {5,6,7},
                {9,10,11}
        };
        int i = new 对角线上的质数().diagonalPrime(nums);
        System.out.println(i);
    }
    public int diagonalPrime(int[][] nums) {
        int length = nums.length;
        int max = 0;
        for(int i = 0 ; i < length ; i ++){
            int x = nums[i][i];
            if( x > max && isPrime(x)){
                max = x;
            }
            x = nums[i][length - i - 1] ;
            if(x > max && isPrime(x))
                max = x;
        }
        return max;
    }
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n >= 2; // 1 不是质数
    }
}
