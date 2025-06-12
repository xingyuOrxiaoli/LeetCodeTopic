package simple.A205;

import java.util.Arrays;

public class 同构字符串 {
    public static void main(String[] args) {
        boolean isomorphic = new 同构字符串().isIsomorphic("egg", "add");
        System.out.println(isomorphic);
    }
    public boolean isIsomorphic(String s, String t) {
        int n = s.length() , m = t.length();
        if(n != m) return false;
        int[] dict1 = new int[256] , dict2 = new int[256];
        Arrays.fill(dict1, -1);
        Arrays.fill(dict2, -1);
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a' , y = t.charAt(i) - 'a';
            if(dict1[x] == -1 && dict2[y] == -1) {
                dict1[x] = i;
                dict2[y] = i;
            }
            if(dict1[x] ==  dict2[y]) continue;
            else return false;
        }

        return true;
    }
}
