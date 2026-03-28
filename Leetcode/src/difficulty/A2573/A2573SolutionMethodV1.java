package difficulty.A2573;

public class A2573SolutionMethodV1  implements A2573Solution{

    @Override
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];

        int start = 0 ;
        for(char c = 'a' ; c <= 'z' ; c++){
            for(int j = start ; j < n ; j++){
                if(lcp[start][j] > 0) {
                    s[j] = c;
                }
            }

            while (start < n && s[start] > 0) {
                start ++;
            }

            if(start == n) {
                break;
            }
        }
        if(start < n) {
            return "";
        }


        for(start = n - 1 ; start >= 0 ; start--){
            for(int j = n - 1 ; j >= 0 ; j--){
                int actualLcp = s[start] != s[j] ? 0 : (start == n - 1 || j == n - 1? 1: lcp[start + 1][j + 1] +1);
                if(lcp[start][j] != actualLcp) {
                    return "";
                }
            }
        }
        return new String(s);
    }
}