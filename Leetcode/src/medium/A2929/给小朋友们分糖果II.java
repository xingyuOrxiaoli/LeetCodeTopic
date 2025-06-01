package medium.A2929;

public class 给小朋友们分糖果II {
    public static void main(String[] args) {

        long l = new 给小朋友们分糖果II().distributeCandies(3, 2);
        System.out.println(l);
        int n = 3 , m = 2;
        long res = new 给小朋友们分糖果II().test(n,m);
        System.out.println(res);
    }

    private long test(int n, int m) {
        if(n > 3 * (m + 1)) return 0;
        return cal(n + 2) - cal(n - m + 1) * 3;
    }

    // 方法 1 枚举
    public long distributeCandies1(int n, int limit) {
        if(limit * 3 <  n) return 0;
        long res = 0 ;


        for(int i = Math.max(0,n - 2 * limit) ; i <= Math.min(n , limit) ;i ++){ // 第一位小朋友拿到的糖果
            res += Math.min(limit , n - i) - Math.max(0,n - i - limit) + 1;
//            for(int j = Math.max(0,n - i - limit) ; j <= Math.min(limit , n - i) ;j ++){
//                res ++;
//            }
        }
        return res;
    }
    // 方法 2 数学原理
    public long distributeCandies(int n, int limit) {
        if(n >= 3 * limit + 1) return 0;
        return cal(n + 2) - 3 * cal(n - limit + 1) + 3 * cal(n - (limit + 1) * 2 + 2) - cal(n - 3 * (limit + 1) + 2);
    }

    public long cal(int x) {
        if (x < 0) {
            return 0;
        }
        return (long) x * (x - 1) / 2;
    }



}
