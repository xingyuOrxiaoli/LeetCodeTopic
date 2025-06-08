package medium.A386;

import java.util.ArrayList;
import java.util.List;

public class 字典序排数 {
    public static void main(String[] args) {
        List<Integer> list = new 字典序排数().lexicalOrder(13);
        System.out.println(list);
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        int temp = 1;
        for(int i = 0 ; i < n ; i ++){
            res.add(temp);
            if(temp * 10 <= n) temp *= 10;
            else{
                while(temp + 1 > n || temp % 10 == 9) temp /= 10;
                temp ++;
            }
        }
        return res;
    }
}
