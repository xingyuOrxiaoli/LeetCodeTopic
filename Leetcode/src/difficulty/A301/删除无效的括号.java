package difficulty.A301;

import java.util.ArrayList;
import java.util.List;

public class 删除无效的括号 {

    public static void main(String[] args) {
        List<String> strings = new 删除无效的括号().removeInvalidParentheses(")(");
        System.out.println(strings);
    }
    private List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0 , rightRemove = 0 , n = s.length();
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '(') leftRemove++;
            else if(s.charAt(i) == ')'){
                if(leftRemove == 0) rightRemove++;
                else leftRemove --;
            }
        }
        dfs(0 , leftRemove, rightRemove , s);
        return res;
    }

    private void dfs(int index, int leftRemove, int rightRemove, String s) {
        if (leftRemove == 0 && rightRemove == 0 && isValid(s)) {
            res.add(s);
            return;
        }
        int n = s.length();
        for(int i = index ; i < n ; i++){
            if(i != index && s.charAt(i) == s.charAt(i - 1)) continue;
            if(leftRemove + rightRemove > n - i) return;
            if(s.charAt(i) == '(' && leftRemove > 0) dfs(i, leftRemove - 1, rightRemove, s.substring(0,i) + s.substring(i + 1));
            if(s.charAt(i) == ')' && rightRemove > 0) dfs(i, leftRemove , rightRemove - 1, s.substring(0,i) + s.substring(i + 1));
        }
    }

    private boolean isValid(String s) {
        int n = s.length() , left = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == ')'){
                if(left == 0) return false;
                else left --;
            }
        }
        return left == 0;
    }
}
class Solution {
    private List<String> res = new ArrayList<String>();

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }
        helper(s, 0, lremove, rremove);

        return res;
    }

    private void helper(String str, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            // 去重
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}
