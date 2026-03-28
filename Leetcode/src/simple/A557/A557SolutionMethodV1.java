package simple.A557;

public class A557SolutionMethodV1  implements A557Solution{

    @Override
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();

        int start = 0;
        for(int i = 0 ; i < n ; i ++) {
            if(s.charAt(i) != ' ') {
                res.insert(start , s.charAt(i));
            } else {
                res.append(" ");
                start = i + 1;
            }
        }
        return res.toString();
    }
}