package medium.A229;

import java.util.ArrayList;
import java.util.List;

public class 多数元素II {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length , val1 = 0 ,val2 = 0 , count1 = 0 , count2 = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(count1 != 0 && nums[i] == val1) count1++;
            else if(count2 != 0 && nums[i] == val2) count2++;
            else if(count1 == 0){
                val1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                val2 = nums[i];
                count2 = 1;
            }else{
                // 开始战斗
                count1 --;
                count2 --;
            }
        }
        // 检验组
        int cnt1 = 0 , cnt2 = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(count1 != 0 && nums[i] == val1) cnt1++;
            if(count2 != 0 && nums[i] == val2) cnt2++;
        }
        int flag = n / 3;
        List<Integer> res = new ArrayList<>();
        if(count1 != 0 && cnt1 > flag) res.add(val1);
        if(count2 != 0 && cnt2 > flag) res.add(val2);
        return res;
    }
}
