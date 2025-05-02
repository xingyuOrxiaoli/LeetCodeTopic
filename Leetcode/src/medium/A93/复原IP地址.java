package medium.A93;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    public static void main(String[] args) {
        List<String> strings = new 复原IP地址().restoreIpAddresses("0000");
        System.out.println(strings);
    }
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() <= 12)
            dfs(s , 0,4,new StringBuilder());
        return res;
    }

    private void dfs(String s,int index, int n, StringBuilder temp) {
        if(n == 1){
            if(s.length() - index  <= 3 && s.length() - index >= 0 &&( s.charAt(index) != '0' || index == s.length() - 1) && Integer.valueOf(s.substring(index)) <= 255) {
                temp.append(s.substring(index));
                res.add(temp.toString());
                temp.delete(temp.length() - s.length() + index, temp.length());
            }
            return;
        }else if(s.length() == index - 1) return;

        Integer value = Integer.valueOf(s.substring(index,index+1));
        for(int i  = 2 ; value <= 255 && index + i <= s.length() ; i++){
            temp.append(value + ".");
            dfs(s, index + i - 1, n - 1, temp);
            temp.delete(temp.length() - String.valueOf(value).length() - 1, temp.length());
            if(s.charAt(index) == '0' && i > 1) break;
            value =Integer.valueOf(s.substring(index,index+i));
        }
    }
}
