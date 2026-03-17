package simple.A409;

import java.util.HashSet;
import java.util.Set;

public class A409SolutionMethodV1 implements A409Solution{
    @Override
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();

        int res = 0 ;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                res += 2;
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        if(!set.isEmpty()) {
            res ++;
        }

        return res;
    }
}
