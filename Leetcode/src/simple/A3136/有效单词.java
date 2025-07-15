package simple.A3136;

public class 有效单词 {
    public static void main(String[] args) {
        boolean valid = new 有效单词().isValid("uHBiL#");
        System.out.println(valid);
    }
    public boolean isValid(String word) {
        int n = word.length() , condition1 = 0 , condition2 = 0 , condition3 = 0;
        word = word.toLowerCase();
        for(int i = 0 ; i < n ; i ++ ){
            char ch = word.charAt(i);
            if(ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u') condition1 ++;
            else if(ch >= 'a' &&  ch <= 'z') condition2 ++;
            else if(ch >= '0' && ch <= '9') condition3 ++;
            else return false;
        }
        if(condition1 + condition2 + condition3> 2 && condition1 > 0 && condition2 > 0 ) return true;
        return false;
    }
}
