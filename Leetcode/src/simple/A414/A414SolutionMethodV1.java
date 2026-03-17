package simple.A414;

public class A414SolutionMethodV1 implements A414Solution{

    @Override
    public int thirdMax(int[] nums) {
        int n = nums.length;
        long res = Long.MIN_VALUE , a = Long.MIN_VALUE, b = Long.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++) {
            int num = nums[i];
            if(num > a) {
                res = b;
                b = a;
                a = num;
            } else if(num > b && num != a) {
                res = b;
                b = num;
            } else if(num != b && num != a) {
                res = Math.max(res,num);
            }
        }
        return (int) (res == Long.MIN_VALUE ? a : res);
    }
}
