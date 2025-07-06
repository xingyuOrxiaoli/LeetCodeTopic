package medium.A241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String expression) {

        // + - * /
        // -1 -2 -3
        List<Integer> ops = new ArrayList<>();
        int  n = expression.length();
        for(int i = 0 ; i <  n ; i ++){
            if(expression.charAt(i) == '+') ops.add(-1);
            else if(expression.charAt(i) == '-') ops.add(-2);
            else if(expression.charAt(i) == '*') ops.add(-3);
            else{
                int num = expression.charAt(i ++) - '0';
                while(i < n && expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                    num = num * 10 + expression.charAt(i ++) - '0';
                }
                ops.add(num);
                i --;
            }
        }
        int m = ops.size();
        List<Integer>[][] dp = new ArrayList[m][m];
        for(int i = 0 ; i < m ; i ++)
            for(int j = 0 ; j < m ; j ++)
                dp[i][j] = new ArrayList<>();
        return dfs(dp , 0 , m - 1 , ops);
    }

    private List<Integer> dfs(List<Integer>[][] dp, int left, int right, List<Integer> ops) {
        if(dp[left][right].isEmpty()){
            if(left == right){
                dp[left][right].add(ops.get(left));
            }else{
                for(int i = left ; i < right ; i+= 2){
                    List<Integer> left_res = dfs(dp,left, i , ops) , right_res = dfs(dp,i + 2 , right, ops);
                                                                        // 对左右进行排列组合
                                                                        Integer finalI = i + 1;
                    left_res.forEach(left_value->right_res.forEach(right_value-> {
                        if(ops.get(finalI) == -1) dp[left][right].add(left_value + right_value);
                        else if(ops.get(finalI) == -2) dp[left][right].add(left_value - right_value);
                        else dp[left][right].add(left_value * right_value);
                    }));
                }
            }
        }
        return dp[left][right];
    }
}


class Solution {
    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<Integer>();
        for (int i = 0; i < expression.length();) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADDITION);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUBTRACTION);
                } else {
                    ops.add(MULTIPLICATION);
                }
                i++;
            } else {
                int t = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);
            }
        }
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }
        return dfs(dp, 0, ops.size() - 1, ops);
    }

    public List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
        if (dp[l][r].isEmpty()) {
            if (l == r) {
                dp[l][r].add(ops.get(l));
            } else {
                for (int i = l; i < r; i += 2) {
                    List<Integer> left = dfs(dp, l, i, ops);
                    List<Integer> right = dfs(dp, i + 2, r, ops);
                    for (int lv : left) {
                        for (int rv : right) {
                            if (ops.get(i + 1) == ADDITION) {
                                dp[l][r].add(lv + rv);
                            } else if (ops.get(i + 1) == SUBTRACTION) {
                                dp[l][r].add(lv - rv);
                            } else {
                                dp[l][r].add(lv * rv);
                            }
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }
}
