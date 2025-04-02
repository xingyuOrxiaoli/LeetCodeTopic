package medium.A17;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        List<String> stringList = new 电话号码的字母组合().letterCombinations("23");
        System.out.println(stringList);
    }
    char[][] dict = new char[][] {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        getStr(res,digits,0,new StringBuilder());
        return res;
    }

    public void getStr(List<String> res , String digits , int index , StringBuilder temp){
        if(index == digits.length()){
            res.add(temp.toString());
            return;
        }
        int dictIndex = digits.charAt(index) - '2';
        for(int i = 0 ; i < dict[dictIndex].length ; i++){
            temp.append(dict[dictIndex][i]);
            getStr(res,digits,index+1,temp);
            temp.deleteCharAt(index);
        }
    }


    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        letterCombinations(res,digits,0,new StringBuilder(digits.length()));
        return res;
    }

    private void letterCombinations(List<String> res, String digits , int index , StringBuilder stringBuilder) {
        if(index == digits.length()){
            res.add(stringBuilder.toString());
            return;
        }
        int temp = digits.charAt(index) - '2';
        for(int i = 0 ; i < dict[temp].length ; i++){
            stringBuilder.append(dict[temp][i]);
            letterCombinations(res,digits,index+1,stringBuilder);
            stringBuilder.deleteCharAt(index);
        }
    }
}
