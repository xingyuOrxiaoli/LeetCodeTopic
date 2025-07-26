package difficulty.A315;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.*;
import java.util.TreeMap;
import java.util.TreeSet;

public class 计算右侧小于当前元素的个数 {
    public static void main(String[] args) {
        List<Integer> list = new 计算右侧小于当前元素的个数().countSmaller(ArrayUtils.createArrayOne("[26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41]"));
        System.out.println(list);
    }


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        BIT bit = new BIT(nums);
        int n = nums.length;
        for(int i  = n - 1 ; i > -1 ; i --){
            int id = bit.getId(nums[i]);
            res.add(0,bit.query(id - 1));
            bit.update(id);
        }

        return res;
    }

    class BIT{
        private int[] sum ;
        private int[] indexs;

        public BIT(int[] nums) {
            this.discretization(nums);
            sum = new int[nums.length];
        }
        private void discretization(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) set.add(num);
            int size = set.size();

            indexs = new int[size];
            int index = 0;
            for (int num : set) indexs[index++] = num;
            Arrays.sort(indexs);
        }

        public int getId(int x) {
            return Arrays.binarySearch(indexs, x) + 1;
        }
        public void update(int index){
            while (index < indexs.length){
                sum[index] ++;
                index += lowBit(index);
            }
        }
        public int query(int index){
            int res = 0;
            while(index > 0){
                res += sum[index];
                index -= lowBit(index);
            }
            return res;
        }

        private int lowBit(int x) {
            return x & (-x);
        }
    }
}

