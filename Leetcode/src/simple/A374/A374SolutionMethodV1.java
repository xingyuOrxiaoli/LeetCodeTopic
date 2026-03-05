package simple.A374;

public class A374SolutionMethodV1 extends GuessGame implements A374Solution{
    @Override
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
