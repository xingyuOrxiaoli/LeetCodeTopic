package simple.A2586;

public class 统计范围内的元音字符串数 {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0 ;
        while(left < right) {
            String word = words[left ++];
            if(isCheck(word.charAt(0)) && isCheck(word.charAt(word.length() - 1))) res ++;
        }
        return res;
    }

    private boolean isCheck(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
