package simple.A392;

public class A392SolutionMethodV1 implements A392Solution{
    @Override
    public boolean isSubsequence(String s, String t) {
        int n = s.length() , m = t.length();
        int i = 0 , j = 0;

        while(i < n && j < m){
            if(s.charAt(i) == t.charAt(j)){
                i ++;
            }
            j ++;
        }
        return i == n;
    }
}
