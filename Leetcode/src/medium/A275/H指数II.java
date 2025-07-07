package medium.A275;

public class H指数II {

    // citations 已经按照 非降序排列  二分
    public int hIndex(int[] citations) {
        int n = citations.length , left = 0, right = n - 1 , mid = left +( (right - left) >> 1) , res = 0 ;
        while (left <= right) {
            if(citations[mid] >= n - mid){
                res = Math.max(res, n - mid);
                right = mid - 1;
            }else left = mid + 1 ;
            mid = left +( (right - left) >> 1) ;
        }
        return res;
    }

}
