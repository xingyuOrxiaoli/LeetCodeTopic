package medium.A201;

public class 数字范围按位与 {
    public static void main(String[] args) {

    }
    public int rangeBitwiseAnd(int left, int right) {

        int bit =  0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            bit ++;
        }
        return left << bit;
    }
}
