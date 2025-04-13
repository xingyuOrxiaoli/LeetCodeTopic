package simple.A58;

public class 最后一个单词的长度 {
    public static void main(String[] args) {
        int i = new 最后一个单词的长度().lengthOfLastWord("   fly me   to   the moon   ");
        System.out.println(i);
    }
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int left = 0 , right = 0 , res = 0 ,n = s.length();
        while(right < n){
            if(s.charAt(right ++) == ' ') {
                if(left != right -1) res = right - left - 1;
                left = right;
            }
        }
        if(left != right) res = right - left;
        return  res ;
    }
}
