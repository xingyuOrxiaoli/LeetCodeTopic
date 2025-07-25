package medium.A1343;

public class 大小为K且平均值大于等于阈值的子数组数目 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0 , n = arr.length , sum = 0;
        threshold *= k;
        for(int i  = 0 ; i < k ; i ++) sum += arr[i];
        if(sum >= threshold) res = 1;
        for(int i  = k ; i < n ; i ++){
            sum -= arr[i - k];
            sum += arr[i];
            if(sum >= threshold) res++;
        }
        return res ;
    }
}
