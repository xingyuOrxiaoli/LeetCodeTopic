package medium.A8;

public class 字符串转换整数atoi {
    public static void main(String[] args) {
        int i = new 字符串转换整数atoi().myAtoi("42");
        System.out.println(i);
    }
    public int myAtoi(String s) {
        s = s.trim();
        char[] ch = s.toCharArray();
        int length = s.length();
        boolean flag = false;
        boolean index = true ;
        int res = 0;

        for(int i  = 0 ; i < length ; i++){
            char temp = ch[i];
            byte num = (byte)(temp - '0');
            if('+' == temp && i == 0 ) continue;
            if('-' == temp && i == 0) {
                flag = true;
                continue;
            }
            if(num > 10 || num < 0 ) break;
            if(index && '0' == temp) continue;
            index = false;

            if(res > 214748364 ||
                    (!flag && (res == 214748364 && num >= 7)) ||
                    (flag  && (res == 214748364 && num >= 8))){
                if(flag) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            res *= 10;
            res += num;
        }
        if(flag) res = -res;

        return res;
    }
}
