package simple.ALCR001;

public class 两数相除 {
    public static void main(String[] args) {
        int res = new 两数相除().divide(-1, 1);
        System.out.println(res);
    }
    int mod = Integer.MAX_VALUE;
    public int divide(int a, int b) {
        if(a == Integer.MIN_VALUE && b == 1) return Integer.MIN_VALUE;
        int op = 1;
        long x = a , y = b;
        if(x * y < 0) op = -1;
        x = Math.abs(x);
        y = Math.abs(y);
        long left = 0 , right = Integer.MAX_VALUE ;
        while (left <= right){
            long mid = (left + right) / 2;
            if(mid * y == x) return (int) (op * mid);
            if(mid * y < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (int) (op * right);
    }
}
