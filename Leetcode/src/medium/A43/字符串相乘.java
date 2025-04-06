package medium.A43;

public class 字符串相乘 {
    public static void main(String[] args) {
        String str = "1";
        for(int i = 1 ; i < 200 ;i ++){
            str += 0;
        }
        System.out.println(str);
        String multiply = new 字符串相乘().multiply("0", "456");
        System.out.println(multiply);
    }
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        if(n < m) return multiply(num2,num1);
        StringBuilder result = multiply(num1, num2.charAt(m - 1) - '0');
        StringBuilder temp ;
        for(int i = m - 2; i >= 0; i--){
            temp = multiply(num1, num2.charAt(i) - '0');
            temp.reverse();
            for(int j = 0 ; j < m - i - 1; j++) temp.append("0");
            result = add(temp.reverse(), result);
        }
        result = result.reverse();
        while(result.length() != 1 &&  result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
    private StringBuilder multiply(String num1, int num2) {
        int t = 0;
        StringBuilder result = new StringBuilder();
        for(int i = num1.length() - 1 ; i >= 0; i-- ){
            t += num2 * (num1.charAt(i) - '0') ;
            result.append(t % 10);
            t /= 10;
        }
        while(t > 0){
            result.append(t % 10);
            t /= 10;
        }
        return result;
    }
    private StringBuilder add(StringBuilder a , StringBuilder b){
        int t = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < b.length(); i++){
            t += a.charAt(i) + b.charAt(i) - '0' - '0';
            result.append(t%10);
            t = t/10;
        }
        for(int i = b.length(); i < a.length() ; i++){
            t += a.charAt(i) - '0';
            result.append(t%10);
            t = t/10;
        }
        while(t > 0){
            result.append(t % 10);
            t /= 10;
        }
        return result;
    }
}
