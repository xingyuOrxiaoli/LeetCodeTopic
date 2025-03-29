package medium.A7;

public class 整数反转 {
    public static void main(String[] args) {
        int reverse = new 整数反转().reverse(123);
        System.out.println(reverse);
    }
    public int reverse(int x) {
        int res = 0 ;
        boolean flag = false; // 正数
        if(x < 0 ) flag = true;
        while(x != 0){
            int temp =x % 10;
            if((res < -429496729)||  res > 429496729 ) return  0 ;
            res *= 10;
            if( res != 0 &&  (res < 0) != flag) return 0;
            res += (temp);
            x /= 10;
        }

        return res;
    }
}
