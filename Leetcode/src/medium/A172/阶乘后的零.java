package medium.A172;

public class 阶乘后的零 {
    public static void main(String[] args) {

    }
    public int trailingZeroes(int n) {
        int two = 0 , five = 0;
        while(n != 0){

            int temp = n;
            while(temp % 2 == 0 && temp != 0){
                two ++;
                temp /= 2;
            }
            while(temp % 5 == 0 && temp != 0){
                five ++;
                temp /= 5;
            }
            n -- ;
        }
        return Math.min(two,five);
    }
}
