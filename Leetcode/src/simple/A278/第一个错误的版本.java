package simple.A278;

public class 第一个错误的版本 {

    public static void main(String[] args) {
        int i = new 第一个错误的版本().firstBadVersion(5);
        System.out.println(i);
    }
    public int firstBadVersion(int n) {
        int left = 1, right = n , mid = left + (right - left) / 2;
        while(left <= right) {
            if(isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
            mid = left + (right - left) / 2;
        }
        return left;
    }

    // 这个是辅助方法 不用实现
    boolean isBadVersion(int version){
        return version >= 4;
    }
}
