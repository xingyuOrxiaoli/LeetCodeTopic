package simple.A2894;

public class 分类求和并作差 {
    public static void main(String[] args) {
        int i = new 分类求和并作差().differenceOfSums2(10, 3);
        System.out.println(i);
    }

    // 方法1 遍历所有
    public int differenceOfSums(int n, int m) {
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(i % m == 0){
                res -=i;
            }else {
                res += i;
            }
        }
        return res;
    }

    // 方法2 数学优化
    public int differenceOfSums2(int n, int m) {
        int res = (m * ( m - 1)) >> 1 , x = n / m , y = n % m , z = 0;
        for(int i = 1 ; i <= x ; i++) z += 2 * i - 1;
        // num1 不能被整除
        res *= z;
        for(int i = x * m + 1 ; i <= n ; i++) res += i;
        // num2 可以被整除
        res -= ((x * (x + 1)) >> 1) * m;

        return res;
    }
}
