package Weekly_competition.two.A153;

import java.util.ArrayList;
import java.util.List;

public class Q2操作后最大活跃区段数I {
    public static void main(String[] args) {
        int i = new Q2操作后最大活跃区段数I().maxActiveSectionsAfterTrade("10110");
        System.out.println(i);
    }
    public int maxActiveSectionsAfterTrade(String s) {
        int max = 0 ;
        int one = 0;
        int zero_pre = 0 ;
        int zero_cur = 0 ;
        s = "1" + s + "1";
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1'){
                if(zero_pre != 0 && zero_cur != 0) {
                    max = Math.max(max, zero_cur + zero_pre);
                }
                if(i >= 1 && s.charAt(i -1) == '0'){
                    zero_pre = zero_cur;
                    zero_cur = 0;
                }
                one ++;
            }
            if(s.charAt(i) == '0'){
                zero_cur ++;
            }
        }

        if(zero_cur != 0){
            max = Math.max(max, zero_cur + zero_pre);
        }
        return one + max -2;
    }
}
