package medium.A2116;

public class 判断一个括号字符串是否有效 {
    public static void main(String[] args) {
        boolean b = new 判断一个括号字符串是否有效().canBeValid("))()))", "010100");
        System.out.println(b);
    }
    public boolean canBeValid(String s, String locked) {
        int length = s.length();
        if(length % 2 == 1) return false;
        int min = 0 ;
        int max = 0 ;
        char[] chs = s.toCharArray();
        char[] chl = locked.toCharArray();
        for(int i = 0 ;i < length ; i++){
            if('1' == chl[i]){
                int temp = -1;
                if('(' == chs[i]){
                    temp = 1;
                }
                max += temp;
                min = Math.max(min + temp , (i + 1) % 2 );
            }else{
                max ++;
                min = Math.max(min -1 , (i + 1) % 2);
            }
            if(max < min){
                return false;
            }
        }

        return min == 0;
    }
}
