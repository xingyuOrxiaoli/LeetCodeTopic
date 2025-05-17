package simple.A118;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public static void main(String[] args) {
        List<List<Integer>> generate = new 杨辉三角().generate(30);
        generate.forEach(System.out::println);
    }

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
}
