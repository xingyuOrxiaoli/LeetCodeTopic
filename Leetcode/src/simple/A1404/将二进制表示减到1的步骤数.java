package simple.A1404;

public class 将二进制表示减到1的步骤数 {

    public int numSteps(String s) {
        int res = 0, t = 0, n = s.length();

        for (int i = n - 1; i > -1; i--) {
            if(s.charAt(i) == '0') {
                if(t == 0) {
                    res ++;
                } else {
                    res += 2;
                }
            }

            if(s.charAt(i) == '1') {
                if(i == 0 && t == 0) {
                    break;
                }

                if(t == 0) {
                    t = 1;
                    res += 2;
                } else {
                    res ++;
                    if(i == 0) {
                        t = 0;
                    }
                }
            }
        }

        return res;
    }

}
