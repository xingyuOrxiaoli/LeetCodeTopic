package simple.A1295;

public class 统计位数为偶数的数字 {

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int numbers = new 统计位数为偶数的数字().findNumbers(nums);
        System.out.println(numbers);
    }
    public int findNumbers(int[] nums) {
        int res = 0 ;

        for(int num : nums)
            if(check(num))
                res ++;
        return res;
    }
    private boolean check(int num) {
        if((num >= 10 && num < 100) || (num >= 1000 && num < 10000) || (num == 100000)) return true;
        return false;
    }
}
