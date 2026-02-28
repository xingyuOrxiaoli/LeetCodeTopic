package simple.A338;

import java.util.Arrays;

public class 比特位计数 {
    public static void main(String[] args) {
        int n = 10;
        A338Solution solution = new A338SolutionMethodV1();
        int[] res = solution.countBits(n);
        System.out.println(Arrays.toString(res));
    }
}
