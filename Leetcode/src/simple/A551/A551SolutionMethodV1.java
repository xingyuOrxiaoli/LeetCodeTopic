package simple.A551;

public class A551SolutionMethodV1  implements A551Solution{

    @Override
    public boolean checkRecord(String s) {
        int a = 0 , l = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'A'){
                a ++;
                l = 0 ;
            } else if(s.charAt(i) == 'L'){
                l ++;
            } else {
                l  = 0;
            }
            if(l == 3 || a == 2) {
                return false;
            }
        }
        return true;
    }
}