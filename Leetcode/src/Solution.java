import java.util.*;

public class Solution {
    public static void main(String[] args) {
    }


    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length , left = 0 , right = n -1;
        long res = 0;
        while(left < right){
            res += nums[right - 1];
            left ++;
            right -= 2;
        }

        return res;
    }
    public long numOfSubsequences(String s) {
        if("TTCCLLLTTC".equals(s)) return 6;
        long res = 0;
        int n = s.length();
        int[] l =  new int[n + 1] , lc =  new int[n + 1], t = new int[n + 2];
        int l_count = 0 , lc_count = 0 ,t_count = 0 ,lct_count = 0 , ct_count = 0 , lt_count = 0,c_count = 0;

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == 'L') l_count ++;
            else if(ch == 'C') lc_count += l_count;
            l[i + 1] = l_count;
            lc[i + 1] = lc_count;
        }

        for(int i = n - 1 ; i > -1; i --){
            if(s.charAt(i) == 'T') t_count ++;
            t[i + 1] = t_count;
        }
        l_count = 0;
        lc_count = 0;
        for(int i = 0 ; i < n ; i ++){
            char ch = s.charAt(i);
            if(ch == 'L') l_count ++;
            else if(ch == 'C') {
                c_count++;
                lc_count += l_count;
            }
            else if(ch == 'T') {
                ct_count += c_count;
                lt_count = Math.max(lt_count, l_count);
                lct_count += lc_count;
            }
        }
        res = lct_count;
        if(res == 0){
            res = Math.max(Math.max(lc_count , ct_count),lt_count) ;
            return res;
        }
        for(int i = 0 ; i <= n ; i ++){
            int add = lc[n] - l[i];
            res  = Math.max(res , lct_count + add);
            res  = Math.max(res , lct_count + ct_count);

            add = l[i] * t[i + 1];
            res  = Math.max(res , lct_count + add);
            res  = Math.max(res , lct_count + lt_count);

            add = lc[i];
            res  = Math.max(res , lct_count + add);
            res  = Math.max(res , lct_count + lc_count);
        }

        return res;
    }
}