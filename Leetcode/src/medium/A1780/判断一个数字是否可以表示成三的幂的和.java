package medium.A1780;

public class 判断一个数字是否可以表示成三的幂的和 {
    public boolean checkPowersOfThree(int n) {
        while(n != 0){
            if(n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }
}
