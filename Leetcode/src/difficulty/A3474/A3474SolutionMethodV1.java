package difficulty.A3474;

import java.util.Arrays;

public class A3474SolutionMethodV1  implements A3474Solution{

    @Override
    public String generateString(String str1, String str2) {

        int n = str1.length() , m = str2.length();
        char[] res = new char[n + m - 1];
        Arrays.fill(res, ' ');

        for(int i = 0 ; i < n ; i ++){
            if(str1.charAt(i) == 'T') {
                for(int j = i , k = 0; j < i + m ; j ++ , k ++) {
                    char ch = str2.charAt(k);
                    if(res[j] == ' ' || res[j] == ch) {
                        res[j] = ch;
                    } else {
                        return "";
                    }
                }
            }
        }
        char[] old = res.clone();
        for (int i = 0; i < res.length; i++) {
            if(res[i] == ' ') {
                res[i] = 'a';
            }
        }

        for(int i = 0 ; i < n ; i ++){
            if(str1.charAt(i) == 'F') {
                if(!new String(res,i,m).equals(str2)) {
                    continue;
                }

                boolean flag  = true;
                for(int j =  i + m - 1 ; j >= i ; j --) {
                    if(old[j] == ' ') {
                        res[j] = 'b';
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return "";
                }
            }
        }

        return new String(res);
    }
}