package simple.A541;

public class A541SolutionMethodV1  implements A541Solution{

    @Override
    public String reverseStr(String s, int k) {
        int n = s.length() , m = n / (k << 1);
        StringBuilder res = new StringBuilder();
        int start = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < k ; j++){
                res.insert(i * 2 * k, s.charAt(start++));
            }
            for(int j = 0 ; j < k ; j++){
                res.append(s.charAt(start++));
            }
        }

        int t = n % (k << 1);
        if(t < k) {
            for(int i = n - 1 ; i >= start ; i --) {
                res.append(s.charAt(i));
            }
        } else {
            for(int i = n - t + k - 1; i >= start ; i --) {
                res.append(s.charAt(i));
            }
            for(int i = n - t + k; i < n ; i ++) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}