package simple.ALCR002;

public class 二进制求和 {
    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int n = a.length(), m = b.length(), t = 0 ;
        while(n != 0 && m != 0){
            t += a.charAt(-- n) + b.charAt(-- m) - '0' - '0';
            res.append(t & 1);
            t >>=1;
        }
        while(n != 0) {
            t += a.charAt(-- n) - '0';
            res.append(t & 1);
            t >>=1;
        }
        while(m != 0) {
            t += b.charAt(-- m) - '0';
            res.append(t & 1);
            t >>=1;
        }
        if(t != 0) res.append(t);
        return res.reverse().toString();
    }
}
