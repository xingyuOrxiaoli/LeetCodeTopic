package simple.A69;

public class x的平方根 {

    public static void main(String[] args) {
        for (int x = 0; x < Integer.MAX_VALUE; x++) {
            int i = new x的平方根().mySqrt(x);
            int res = (int) Math.sqrt(x);
            if(i == res ){
                System.out.println("[INFO] 通过测试案例 x = " + x );
            }else{
                System.out.println("[WARN] 未通过测试案例 x = " + x +"\t我的答案为 :" + i + "\t标准答案为: "  + res );
                new x的平方根().mySqrt(x);
                return;
            }
        }
        System.out.println("AC 通过所有测试用例");
    }

    // 二分
    public int mySqrt(int x) {
       int left = 0 ,right = x /  2 + 1 ,  mid = 1;
       while (left <= right && mid != 0) {
           mid = (left + right) / 2;
           if(mid * mid== x) return mid;
           if((long)mid * mid > x) right = mid - 1;
           else left = mid + 1;
       }
       return right;
    }
}
