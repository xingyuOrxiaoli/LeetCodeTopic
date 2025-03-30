package medium.A29;

public class 两数相除   {
    public static void main(String[] args) {
        int divide = new 两数相除().divide(-2147483648, -1);
        System.out.println(divide == 2147483647);
    }
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }
}
