package simple.A387;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;

        for(int i  = 0 ; i < n ; i ++)
            if(count[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
}
