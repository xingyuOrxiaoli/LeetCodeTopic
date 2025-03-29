package simple.A2716;

public class 最小化字符串长度 {

    public static void main(String[] args) {
        String str = "aaaba";
        int i = new 最小化字符串长度().minimizedStringLength(str);
        System.out.println(i);
    }

    // 从题解学到的优化，因为最多26int类型对于26个1是能存储下的
    public int minimizedStringLength(String s) {
        int res = 0;
        for(char ch : s.toCharArray()){
            res |= 1 << (ch - 'a');
        }
        return Integer.bitCount(res);
    }
    // 自己的解法
    // public int minimizedStringLength(String s) {
    //     int res = 0 ;
    //     int length  = s.length();
    //     char[] ch = s.toCharArray();
    //     boolean[] st = new boolean[26];
    //     for(int i = 0; i < length; i++){
    //         st[ch[i] - 'a'] = true;
    //     }
    //     for(int i  = 0 ; i < 26 ; i++){
    //         if(st[i]){
    //             res++;
    //         }
    //     }
    //     return res;
    // }
}
