package simple.A3330;

public class 找到初始输入字符串I {
    public static void main(String[] args) {

    }
    public int possibleStringCount(String word) {
        int n = word.length() , res = 1, left = 0;
        for(int i = 1 ; i < n ; i ++){
            if(word.charAt(i) == word.charAt(left)) res ++;
            else left = i;
        }

        return res;
    }

}
