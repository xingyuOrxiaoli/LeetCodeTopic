package medium.A22;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        List<String> stringList = new 括号生成().generateParenthesis(3);
        System.out.println(stringList);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res =  new ArrayList<>();
        generateParenthesis(n,0,0,new StringBuilder(),res);
        return res;
    }

    public void generateParenthesis(int n , int left ,int right,StringBuilder str,List<String> res){
        if(left == n && right == n){
            res.add(str.toString());
            return;
        }
        if(left < n){
            str.append('(');
            generateParenthesis(n,left+1 ,right,str,res);
            str.deleteCharAt(str.length()-1);
        }
        if(left > right){
            str.append(')');
            generateParenthesis(n,left ,right + 1,str,res);
            str.deleteCharAt(str.length()-1);
        }

        // if(left == right){
        //     str.append('(');
        //     generateParenthesis(n,left + 1 , right,str,res);
        //     str.deleteCharAt(str.length()-1);
        // }else{
        //     if(left < n){
        //         str.append('(');
        //         generateParenthesis(n,left+1 ,right,str,res);
        //         str.deleteCharAt(str.length()-1);
        //     }
        //     str.append(')');
        //     generateParenthesis(n,left ,right + 1,str,res);
        //     str.deleteCharAt(str.length()-1);
        // }
    }
}
