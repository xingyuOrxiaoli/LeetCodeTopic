package simple.A面试题_01_06;

public class 字符串压缩 {
    public String compressString(String S) {

        int n = S.length() , count = 0 ;
        if(n == 0) return S;
        StringBuilder res  = new StringBuilder();
        char cur = S.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if(c == cur) count ++;
            else{
                res.append(cur);
                res.append(count);
                cur = c;
                count = 1;
            }
        }
        res.append(cur);
        res.append(count);

        return res.length() < n ? res.toString() : S;
    }
}
