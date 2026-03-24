package simple.A504;

public class A504SolutionMethodV1  implements A504Solution{

    @Override
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        boolean flag = num < 0;

        num = Math.abs(num);
        while (num != 0) {
            res.insert(0,num % 7);
            num /= 7;
        }
        if(flag) {
            res.insert(0,'-');
        }
        return res.toString();
    }
}