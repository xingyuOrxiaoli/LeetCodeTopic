package difficulty.A282;

import java.util.ArrayList;
import java.util.List;

public class 给表达式添加运算符 {

    public static void main(String[] args) {
        List<String> strings = new 给表达式添加运算符().addOperators("2147483648", -2147483648);
        System.out.println(strings);
    }
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {

        dfs(num , 0 , 0l,  1l , 1, num.length(), target , new StringBuilder());


        return res;
    }

    private void dfs(String num, int index, long curValue, long preValue , int preOp , int length, int target, StringBuilder path) {
        if(curValue == target && index == length) {
            res.add(path.toString());
            return;
        }
        if(index == length) return;
        long value = 0 ;
        StringBuilder valueStr = new StringBuilder();
        for(int i = index; i < length ; i++) {
            if(value == 0 && valueStr.length() != 0) break;
            int ch =  num.charAt(i) - '0';
            value = value * 10 + ch; // 长度为 i - index + 1
            valueStr.append(ch);

            // 加
            if(index == 0) path.append(valueStr);
            else path.append("+" + valueStr);
            dfs(num, i + 1, curValue + value, value , 1 , length, target, path);
            if(index == 0) path.delete(0 , path.length());
            else path.delete(path.length() - i + index - 2 , path.length());

            // 减法
            if(index == 0) continue;
            else path.append("-" + valueStr);
            dfs(num, i + 1, curValue - value,value , -1, length, target, path);
            if(index == 0) path.delete(0 , path.length());
            else path.delete(path.length() - i + index - 2 , path.length());

            // 乘法
            if(index == 0) continue;
            else path.append("*" + valueStr);
            long pre  = curValue - preOp * preValue  , cur = pre + preOp * preValue * value;

            dfs(num, i + 1, cur, preValue * value, preOp,length, target, path);
            if(index == 0) path.delete(0 , path.length());
            else path.delete(path.length() - i + index - 2 , path.length());
            if(value == 0) break;
        }
    }
}
