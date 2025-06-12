package medium.A201;

public class 数字范围按位与 {
    public static void main(String[] args) {

    }
    public int rangeBitwiseAnd(int left, int right) {
        return (left & (right - 1)) | ((right - 1) & (right - 1));
    }
}
