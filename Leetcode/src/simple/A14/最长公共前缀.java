package simple.A14;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] str = new String[]{"flower","flow","flight"};
        String s = new 最长公共前缀().longestCommonPrefix(str);
        System.out.println(s);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        int length = strs.length;
        for(int i = 1 ; i < length ; i++){
            int templength = Math.min(res.length(), strs[i].length());
            int temp = 0;
            while(temp < templength && res.charAt(temp) == strs[i].charAt(temp)){
                temp ++;
            }
            res = res.substring(0,temp);
            if(res.length() == 0) break;
        }
        return res;
    }
}
