package simple.A2839;

public class A2839SolutionMethodV1  implements A2839Solution{

    @Override
     public boolean canBeEqual(String s1, String s2) {
        char[] s = s1.toCharArray();

        for(int i = 0 ; i < 2 ; i ++) {
            char ch2 = s2.charAt(i);
            if(s[i] == ch2) {
                continue;
            } else if(s[i + 2] == ch2){
                s[i + 2] = s[i];
                s[i] = ch2;
            } else {
                return false;
            }
        }

        for(int i = 2 ; i < 4 ; i ++) {
            if(s[i] == s2.charAt(i)){
                continue;
            }else {
                return false;
            }
        }


        return true;
    }
}