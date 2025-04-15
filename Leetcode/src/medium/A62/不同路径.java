package medium.A62;

public class 不同路径 {
    public static void main(String[] args) {
        int i = new 不同路径().uniquePaths(3,7);
        System.out.println(i);
    }
    public int uniquePaths(int m, int n) {
        int min = Math.min(m,n) - 1;
        n += m - 2;
        int res = 1;
        for(int i = 1 ; i <= min ; i++)  res *= (n --);
        for(int i = 1 ; i <= min ; i++)  res /= i;
        return res;
    }
    public int factorial (int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}

