package simple.A67;

public class 二进制求和 {

    public static void main(String[] args) {
        String s = new 二进制求和().addBinary("11", "1");
        System.out.println(s);
    }
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) return addBinary(b, a);
        int n = a.length() - 1 , m = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int t = 0 ;
        while( m > - 1){
            t += a.charAt(n--) - '0' + b.charAt(m--) - '0';
            res.append(t & 1);
            t = t >> 1;
        }
        while (n > - 1){
            t += a.charAt(n--) - '0';
            res.append(t & 1);
            t = t >> 1;
        }
        if (t != 0) res.append(t);
        return res.reverse().toString();
    }

}
