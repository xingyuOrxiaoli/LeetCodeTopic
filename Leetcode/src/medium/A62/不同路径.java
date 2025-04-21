package medium.A62;

public class 不同路径 {
    public static void main(String[] args) {
        for(int i = 1 ; i <= 100 ; i ++){
            for(int j = 1 ; j <= 100 ; j ++){
                int res    =  new 不同路径().uniquePaths(i,j);
                int newRes =  new 不同路径().uniquePaths_2(i,j);
                if(res == newRes) System.out.println("[INFO] 通过测试案例 m = " + i + "\t n = " + j);
                else{
                    System.out.println("[INFO] 未能通过测试案例 m = " + i + "\t n = " + j +"\t res = " + res + "\t newRes = " + newRes);
                    int temp = new 不同路径().uniquePaths_2(i,j);
                    System.out.println("temp = " + temp + "\t n = " + j);
                    return;
                }
            }
        }
        int i = new 不同路径().uniquePaths_2(3,7);
        System.out.println(i);
    }
    public int uniquePaths(int m, int n) {
        int min = Math.min(m,n) - 1;
        n += m - 2;
        long res = 1;
        for(int i = 1 ; i <= min ; i++)  res *= (n --);
        for(int i = 1 ; i <= min ; i++)  res /= i;
        return (int)res;
    }
    public int factorial (int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }

    // 练习2
    public int uniquePaths_2(int m, int n) {
        long res  = 1;
        int up = Math.min(m,n) - 1;
        n += m - 2;
        for(int i = 1 ; i <= up ; i++){
            res *= (n - i + 1);
            res /= i;
        }
        return (int)res;
    }
}

