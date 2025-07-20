package simple.A1422;

public class 分割字符串的最大得分 {
    public int maxScore(String s) {
        int n = s.length() , left = 0, right = 0 ,res = 0 ;
        for(int i = 0 ; i < n ; i ++)
            if(s.charAt(i) == '1') right ++;

        for(int i = 0 ; i < n ; i ++){
            if(s.charAt(i) == '0') left ++;
            else right --;
            res = Math.max(res, right -left);
        }
        return res;
    }
}
