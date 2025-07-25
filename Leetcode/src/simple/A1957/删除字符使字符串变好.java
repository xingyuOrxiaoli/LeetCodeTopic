package simple.A1957;

public class 删除字符使字符串变好 {
    public static void main(String[] args) {
        String s = new 删除字符使字符串变好().makeFancyString("leeetcode");
        System.out.println(s);
    }
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length(), count = 1;
        char ch =' ';
        for(int i = 0 ;i <  n ; i++){
            char t_ch = s.charAt(i);
            if(t_ch == ch && count == 2) continue;
            if(t_ch == ch) count ++;
            else {
                ch = t_ch;
                count = 1;
            }
            res.append(ch);
        }


        return res.toString();
    }
}
