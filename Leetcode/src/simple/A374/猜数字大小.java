package simple.A374;

public class 猜数字大小 {
}
class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n , mid;
        while (left <= right) {
            mid = left + ((right  - left ) >> 1);
            if(guess(mid) == 0) return mid;
            else if(guess(mid) == 1) left = mid + 1 ;
            else right = mid - 1 ;
        }

        return left;
    }
}
class GuessGame{
    public int guess(int n) {
        return 0;
    }
}