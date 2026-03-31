package simple.A645;

import java.lang.reflect.Array;

public class A645SolutionMethodV1  implements A645Solution{

    @Override
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] dict = new int[n];
        int[] res = new int[2];
        for(int i = 0 ; i < n ; i++){
            int num = nums[i] - 1;
            dict[num] ++;
            if(dict[num] == 2) {
                res[0] = num + 1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(dict[i] == 0) {
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }
}