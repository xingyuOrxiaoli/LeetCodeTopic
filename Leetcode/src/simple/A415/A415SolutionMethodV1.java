package simple.A415;

public class A415SolutionMethodV1 implements A415Solution{
    @Override
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int n = num1.length() - 1 , m = num2.length() - 1, t = 0;

        while(n > -1 && m > -1){
            t += num1.charAt(n --) - '0' + num2.charAt(m --) - '0';
            res.insert(0, t % 10);
            t /= 10;
        }
        while (n > -1) {
            t += num1.charAt(n --) - '0';
            res.insert(0 , t % 10);
            t /= 10;
        }
        while (m > -1) {
            t += num2.charAt(m --) - '0';
            res.insert(0 , t % 10);
            t /= 10;
        }
        if(t != 0) res.insert(0 , t);

        return res.toString();
    }
}
