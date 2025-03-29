package simple.A20;

public class 有效的括号 {
    public static void main(String[] args) {
        boolean valid = new 有效的括号().isValid("()");
        System.out.println(valid);
    }
    public boolean isValid(String s) {
        if(s == null || s.length() % 2 == 1) return false;
        boolean res = true;
        int length = s.length();
        char[] ch = s.toCharArray();
        char[] stack = new char[length + 10];
        int index = 0 ;
        for(int i = 0 ;i < length ; i++){
            if('(' == ch[i] || '[' == ch[i] || '{' == ch[i]){
                stack[index ++ ] = ch[i];
            }else{
                if(index == 0) return false;
                switch (ch[i]){
                    case ')':
                        if(stack[index -1] != '(') return false;
                        else index -- ;
                        break;
                    case ']':
                        if(stack[index -1] != '[') return false;
                        else index -- ;
                        break;
                    case '}':
                        if(stack[index -1] != '{') return false;
                        else index -- ;
                        break;
                }
            }
        }
        if(index != 0) res = false;
        return res;
    }
}
