package medium.A43;

public class 字符串相乘 {
    public static void main(String[] args) {
        String str = "1";
        for(int i = 1 ; i < 200 ;i ++){
            str += 0;
        }
        字符串相乘 ob = new 字符串相乘();
        String num1 = "" , num2 = "" ;
        for(int i = 1 ; i < 200 ;i ++){
            for(int j = 1 ; j < 10 ; j++){
                for(int k = 1 ; k < 200 ; k++){
                    num1 = num1 + "" + j;
                    num2 = num2 + "" + j;
                    if(!ob.multiply(num1,num2).equals(ob.multiply2(num1,num2))){
                        System.out.println(num1);
                        System.out.println(num2);
                        return;
                    }else{
                        System.out.println("[INFO] 用例" + num1 + " -- " + num2 +"测试通过");
                    }
                    num1 = num1.substring(0,num1.length()-1);
                }
            }
        }
        System.out.println(str);
        String multiply = new 字符串相乘().multiply("0", "456");
        System.out.println(multiply);
        String multiply2 = new 字符串相乘().multiply2("123", "456");
        System.out.println(multiply2);

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

    public String multiply2(String num1, String num2) {
        if (num1.length() < num2.length()) multiply2(num2, num1);
        StringBuilder res = new StringBuilder(), temp = new StringBuilder();
        int n1 = num1.length(), n2 = num2.length();
        for (int i = 0 ; i < n2; i ++ ) {
            res.insert(0, '0');
            // 乘法
            int value2 = num2.charAt(i) - '0', t = 0;
            for (int j = n1 - 1; j > -1; j--) {
                int value1 = num1.charAt(j) - '0';
                t += value1 * value2;
                temp.append(t % 10);
                t /= 10;
            }
            if (t != 0) temp.append(t);
            // 加法
            t = 0;
            int ti = 0, ri = 0;
            StringBuilder mid = new StringBuilder();
            while (ri < res.length() && ti < temp.length()) {
                t += temp.charAt(ti++) - '0' + res.charAt(ri++) - '0';
                mid.append(t % 10);
                t /= 10;
            }
            while (ri < res.length()) {
                t += res.charAt(ri++) - '0';
                mid.append(t % 10);
                t /= 10;
            }
            while (ti < temp.length()) {
                t += temp.charAt(ti++) - '0';
                mid.append(t % 10);
                t /= 10;
            }
            temp.delete(0, ti);
            if (t != 0) mid.append(t);
            res = mid;
        }
        while(res.length() > 1 && res.charAt(res.length() - 1) == '0')
            if(res.charAt(res.length() - 1) == '0') res.deleteCharAt(res.length() - 1);
        return res.reverse().toString();
    }
}
