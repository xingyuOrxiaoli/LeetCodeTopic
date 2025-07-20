package medium.A503;

import java.util.*;

public class 下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = (n << 1) - 1 ; i > -1 ; i --){
            int x = nums[i % n];
            while (!stack.isEmpty() && x >= stack.peek())stack.pop();

            if(i < n && !stack.isEmpty()) res[i] = stack.peek();

            stack.push(x);
        }
        return res;
    }
}
