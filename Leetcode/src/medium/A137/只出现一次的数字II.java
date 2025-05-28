package medium.A137;

import utils.ArrayUtils;

public class 只出现一次的数字II {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[2,2,3,2]");
        int i = new 只出现一次的数字II().singleNumber(nums);
        System.out.println(i);
    }
    //
    public int singleNumber(int[] nums) {
        int res = 0 ;
        for(int i = 0 ; i < 32 ; i ++){
            int temp = 0 ;
            for (int num : nums) {
                temp += ((num >> i) & 1);
            }
            if(temp % 3 != 0) res |= (1 << i);
        }
        return res;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        //ab有00 01和10三种表达方式，a为1的时候代表该位置上的1已经出现了两次，对应某数字已经出现了两次
        //所以a为1的时候b只能为0，表现为& ~a，a为0的时候则通过 b | 当前数字来更新b
        int a = 0,b = 0;
        for(int x : nums){
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        // 返回b是因为b是真正统计了进行模3之后出现了一次的位
        // 出现3次的数字在b站对应的位模3后是为0，只有出现一次的数字在b上对应的位为1
        return b;
    }
}