package simple.A228;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间 {
    public static void main(String[] args) {

    }
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if(nums.length==0) return res;
        int n = nums.length, left = nums[0],right = left;

        for(int i = 0;i<n;i++){
            if(right == nums[i]){
                right ++;
                continue;
            }
            if(left == right - 1){
                res.add(left+"");
            }else{
                res.add(left + "->"+(right - 1));
            }
            left = nums[i];
            right = left + 1;
        }

        if(left == right - 1){
            res.add(left+"");
        }else{
            res.add(left + "->"+(right - 1));
        }

        return res;
    }
}
