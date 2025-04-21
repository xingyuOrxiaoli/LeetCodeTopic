package medium.A71;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 简化路径 {

    public static void main(String[] args) {
        String s = new 简化路径().simplifyPath("/../");
        System.out.println(s);
    }

    public String simplifyPath(String path) {
        int n = path.length() , index = -1;
        StringBuilder res = new StringBuilder(n);
        String[] split = path.split("/");
        int[] stack = new int[split.length + 10];
        for (int i = 0; i < split.length; i++) {
            if(split[i].equals("") || split[i].equals(".")) continue;
            if(split[i].equals("..")){
                if(index == -1) continue;
                res.delete(res.length() - stack[index--] - 1, res.length());
            }else{
                res.append("/");
                res.append(split[i]);
                stack[++index] = split[i].length();
            }
        }
        if(res.length() == 0) res.append("/");
        return res.toString();
    }
}
