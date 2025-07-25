package medium.A1717;

import medium.A1695.删除子数组的最大得分;
import utils.ArrayUtils;

public class 删除子字符串的最大得分 {
    public static void main(String[] args) {
        int res = new 删除子字符串的最大得分().maximumGain("cdbcbbaaabab",4,5);

        System.out.println(res);
    }
    public int maximumGain(String s, int x, int y) {
        if(x < y){
            x = x ^ y;
            y = y ^ x;
            x = x ^ y;
            s = s.replace('a' , ' ').replace('b','a').replace(' ' , 'b');
        }
        int n = s.length() , res  = 0;

        for(int i = 0 ; i < n ; i ++){
            int a  = 0 , b = 0 ;
            while(i < n  && (s.charAt(i) == 'a' || s.charAt(i) == 'b')){
                char ch = s.charAt(i ++);
                if(ch == 'a'){
                    a ++;
                }else if(ch == 'b'){
                    if(a > 0){
                        a -- ;
                        res += x;
                    }else b ++;
                }
            }
            res += Math.min(a,b) * y;
        }
        return res;
    }
}
class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = s.replace('a', '\0').replace('b', 'a').replace('\0', 'b');
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cntA = 0, cntB = 0;
            while (i < s.length() && (s.charAt(i) == 'a' || s.charAt(i) == 'b')) {
                char c = s.charAt(i++);
                if (c == 'a'){
                    cntA++;
                }
                else {
                    if (cntA > 0) {
                        cntA--;
                        ans += x;
                    } else {
                        cntB++;
                    }
                }
            }
            ans += Math.min(cntA, cntB) * y;
        }
        return ans;
    }
}