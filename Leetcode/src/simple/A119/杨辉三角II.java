package simple.A119;


import java.util.ArrayList;
import java.util.List;

public class 杨辉三角II {
    public static void main(String[] args) {
        List<List<Integer>> generate = new 杨辉三角II().generate(30);
        generate.forEach(System.out::println);
    }

    // 方法1 使用杨辉三角I中的函数
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1 ; i <= numRows ; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if(i >= 2){
                List<Integer> list = res.get(i - 2);
                for(int j = 1 ; j <= i - 2 ; j++){
                    row.add(list.get(j - 1) + list.get(j));
                }
            }

            if(i != 1) row.add(1);
            res.add(row);
        }

        return res;
    }
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> res = generate(numRows + 1);
        return res.get(numRows);
    }

    // 方法2
    public List<Integer> getRow2(int numRows) {
        List<Integer> res = new ArrayList<>() , pre = new ArrayList<>();
        pre.add(1);
        for(int i = 0 ; i <= numRows ; i++) {
            for(int j = 0 ; j <= i  ; j++){
                if(j == 0 || j == i) res.add(1);
                else res.add(pre.get(j - 1) + pre.get(j));
            }
            pre = res;
            res = new ArrayList<>();
        }

        return res;
    }

    // 方法三 数学公式直接求第N行的
    public List<Integer> getRow3(int numRows) {
        List<Integer> res = new ArrayList<>() ;
        res.add(1);
        for(int i = 1; i <= numRows ; i++) {
            res.add((int) ((long)res.get(i - 1) *(numRows - i + 1) / i));
        }

        return res;
    }

}
