package simple.A1652;

import utils.ArrayUtils;

import java.util.Arrays;

public class 拆炸弹 {
    public static void main(String[] args) {
        int[] res = new 拆炸弹().decrypt(ArrayUtils.createArrayOne("[2,4,9,3]"), -2);
        System.out.println(Arrays.toString(res));

    }
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k == 0) return res;
        if(k > 0){
            int sum = 0;
            for(int i =  0 ; i < k ; i ++) sum += code[i];
            for(int i  = 0 ; i < n ; i ++){
                sum -= code[i];
                sum += code[(i + k) % n];
                res[i] = sum;
            }
        }else{
            int sum = 0;
            for(int i =  -1 ; i >= k ; i --) sum += code[(i + n) % n];
            for(int i  = 0 ; i < n ; i ++){
                res[i] = sum;
                sum -= code[(i + k + n) % n];
                sum += code[i];
            }
        }

        return res;
    }
}
