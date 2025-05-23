package difficulty.A3068;

import utils.ArrayUtils;

import java.util.Arrays;

public class 最大节点价值之和 {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createArrayOne("[78,43,92,97,95,94]");
        int[][] edges = ArrayUtils.createArrayTwo("[[1,2],[3,0],[4,0],[0,1],[1,5]]");
        long l = new 最大节点价值之和().maximumValueSum1(nums, 6, edges);
        System.out.println(l == 507);

    }

    // 贪心  TODO 未考虑到  x y z   x y 进行更新之后  x z不会再更新   但是x y的更新未必有 x z 更新后的增量大
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res = 0 ;
        int n = nums.length , m = edges.length;

        for(int i = 0 ; i < m ; i++) {
            int x = edges[i][0], y = edges[i][1];
            int value_x = nums[x] , value_y = nums[y];
            int value_new_x = value_x ^ k , value_new_y = value_y ^ k ;
            if(value_new_x + value_new_y > value_x + value_y){
                nums[x] = value_new_x;
                nums[y] = value_new_y;
            }
        }
        for(int i = 0 ; i < n ; i++) res += nums[i];

        return res ;
    }
    // 贪心  TODO 未考虑到  x y z   x y 进行更新之后  x z不会再更新   但是x y的更新未必有 x z 更新后的增量大
    // 改进  使用一个数组存储每次更新的值 之后只加上这个数组大于0的值
    // 异或两次就是本身   因此只有有一个有增长就行 前提是两对  比如  x 增加  y 增加 z 减少   x  z 增加x  z y 增加y  第二次z回滚原本的值
    public long maximumValueSum1(int[] nums, int k, int[][] edges) {
        long res = 0 ;
        int[] s = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++) {
            res += nums[i];
            s[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(s);
        for(int i = s.length - 1 ; i > 0 && s[i] + s[ i - 1] > 0 ; i -= 2){
            res += s[i] + s[i - 1];
        }

        return res ;
    }
}
