package simple.A482;

public class A482SolutionMethodV1  implements A482Solution{

    @Override
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder(s.toUpperCase());
        int num = 0;
        for(int i = res.length() - 1; i > -1 ; i --) {
            if(res.charAt(i) == '-') {
                res.deleteCharAt(i);
                continue;
            }
            if(++num == k) {
                res.insert(i,'-');
                num = 0;
            }
        }
        while (res.length() > 0 && res.charAt(0) == '-') {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}