package medium.A89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 格雷编码 {
    public static void main(String[] args) {
        List<Integer> list = new 格雷编码().grayCode(2);
        System.out.println(list);
        System.out.println(1 << 16);
        for(int i = 1 ; i <= 16 ; i ++){
            String ans = new 格雷编码().grayCode(i).toString();
            String res = new 格雷编码().grayCode2(i).toString();
            if (ans.equals(res)){
                System.out.println("[INFO] 通过测试案例 n = " + i);
            }else{
                System.out.println("[WARN] 未通过测试案例 n = " + i);
                System.out.println("ans = " + ans);
                System.out.println("res = " + res);
                return;
            }
        }
    }

    // 方法1 归纳法 参考链接 :
    // https://leetcode.cn/problems/gray-code/solutions/1196538/ge-lei-bian-ma-by-leetcode-solution-cqi7/
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int l = 1; l <= n; l++) {
            int m = res.size();
            for(int r = m - 1 ; r > -1 ; r --){
                res.add(res.get(r) + (1 << (l - 1)));
            }
        }
        return res;
    }


    // 方法2 公式法 参考链接 :
    // https://leetcode.cn/problems/gray-code/solutions/1196538/ge-lei-bian-ma-by-leetcode-solution-cqi7/
    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < 1 << n ; i ++){
            res.add((i >> 1) ^ i);
        }
        return res;
    }
}
