package difficulty.A32;

public class 最长有效括号 {
    public static void main(String[] args) {
        System.out.println(new 最长有效括号().longestValidParentheses("(()") == 2);
        System.out.println(new 最长有效括号().longestValidParentheses(")()())") == 4);
        System.out.println(new 最长有效括号().longestValidParentheses("") == 0);
        System.out.println(new 最长有效括号().longestValidParentheses("()))))))()") == 2);
        System.out.println(new 最长有效括号().longestValidParentheses("()(()") == 2);
        System.out.println(new 最长有效括号().longestValidParentheses("()(()()") == 4);
        System.out.println(new 最长有效括号().longestValidParentheses("(()(((()") == 2);
        System.out.println(new 最长有效括号().longestValidParentheses("(") == 2);
        System.out.println(new 最长有效括号().longestValidParentheses("()") == 2);
    }
    public int longestValidParentheses(String s) {
        int res = 0 , j = 0 ;
        int length = s.length();
        char[] ch = s.toCharArray();
        int[] stack = new int[length + 10];
        stack[0] =  -1 ;
        for(int i = 0 ; i < length ; i++){
            if(ch[i] == '('){
                stack[++j] = i;
            }else{
               j -- ;
               if(j != -1){
                   res = Math.max(res, i - stack[j]);
               }else {
                   stack[++j] = i;
               }
            }
        }
        return res;
    }
}
