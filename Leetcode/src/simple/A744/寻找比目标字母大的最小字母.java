package simple.A744;

public class 寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = 'z' + 1;
        int n = letters.length;
        for(int i = 0 ; i <  n ; i++){
            if(letters[i] > target) res = (char) Math.min(res , letters[i]);
        }

        if(res == 'z' + 1) return letters[0];
        return res;
    }
}
