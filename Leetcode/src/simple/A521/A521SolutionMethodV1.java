package simple.A521;

public class A521SolutionMethodV1  implements A521Solution{

    @Override
    public int findLUSlength(String a, String b) {
        int n = a.length() , m = b.length();
        if(n != m) {
            return Math.max(n,m);
        }

        for(int i = 0 ; i < n ; i ++) {
            if (a.charAt(i) != b.charAt(i)) {
                return n;
            }
        }

        return -1;
    }
}