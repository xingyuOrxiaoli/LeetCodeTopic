package difficulty.A2612;

import java.util.Arrays;
import java.util.TreeSet;

public class 最少翻转操作数 {
    public static void main(String[] args) {
        int[] banned = new int[]{1,2};
        int[] ints = new 最少翻转操作数().minReverseOperations(4, 0, banned, 4);
        System.out.println(Arrays.toString(ints));
    }
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] res = new int[n];
        int length = banned.length;
        int[] fbanned = new int[n];
        int [] q1 = new int[n + 10];
        Arrays.fill(res,-1);
        for(int i = 0 ; i < length ; i++) fbanned[banned[i]] = -1;
        // 参考官方题解方法1的优化
        TreeSet<Integer>[] sets = new TreeSet[2];
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();
        for(int i = 0 ;i < n ; i++) {
            if(i != p && fbanned[i] != -1){
                sets[i % 2].add(i);
            }
        }

        int start  = -1;
        int end    = 0;
        q1[0] = p;
        res[p] = 0;
        while(start < end){
            int temp1  = q1[++start];
            int temp2  = res[temp1];

            // 优化处
            // for(int i = 0 ; i < k ; i++){
            //     int step = k - 2 * i - 1;
            //     if(step == 0 || (step > 0 && (temp1 - i < 0 || temp1 + k - i > n) ) || (step < 0 && (temp1 + k - i > n || temp1 - i < 0 ) ))
            //         continue;
            //     int index  =  temp1 + step;
            //     if(index < n && index >= 0 && fbanned[index] != -1 && res[index] == -1) {
            //         q1[++end] = index;
            //         res[index] = temp2 + 1;
            //     }
            // }

            // 优化后
            int left = Math.max(temp1 -k + 1,k - temp1 - 1);
            int right = Math.min(temp1 + k -1 , n * 2 - k - temp1 - 1);
            TreeSet<Integer> set = sets[right % 2];
            Integer elm = set.ceiling(left);
            while(elm != null && elm <= right){
                res[elm] = temp2 + 1;
                q1[++end] = elm;
                set.remove(elm);
                elm = set.ceiling(left);
            }
        }
        return res;
    }
}
