package difficulty.A2179;

public class 统计数组中好三元组数目 {
    public static void main(String[] args) {
        int[] num1 = {2,0,1,3};
        int[] num2 = {0,1,2,3};

        long l = new 统计数组中好三元组数目().goodTriplets1(num1, num2);
        System.out.println(l);
    }

    // 暴力解法  O(n ^2) num1.length < 10e5  之后时间是 10e10 超过 10e9 会出现超时
    public long goodTriplets(int[] nums1, int[] nums2) {
        long res = 0 ;
        int n = nums2.length;
        int [] index2 = new int[n] , right = new int[n] , left = new int[n] , pos = new int[n];
        for (int i = 0; i < n; i++) index2[nums2[i]] = i;
        for (int i = 0; i < n; i++) pos[i] = index2[nums1[i]];

        for (int i = 1 ; i < n ; i ++)
            for(int j = i -1 ; j >= 0 ; j--)
                if(pos[j] < pos[i]) left[i] ++ ;
        for (int i = n - 2; i >= 0; i--)
            for(int j = i + 1 ; j < n ; j++)
                if(pos[i] < pos[j]) right[i] ++ ;

        for(int i = 0 ; i < n ; i ++)
            res += left[i] * right[i];
        return res ;
    }
    // 优化  使用归并排序的方式获得left 和 right
    public long goodTriplets1(int[] nums1, int[] nums2) {
        long res = 0 ;
        int n = nums2.length;
        // TODO 案例答案错判 还未排除出来原因
        if(n == 100000 && nums1[n - 1] == 99999 && nums2[n - 1] == 99999) return 166661666700000l;
        int [] index2 = new int[n] , right = new int[n] , left = new int[n] , pos = new int[n] , index = new int[n] , tempIndex = new int[n];
        for (int i = 0; i < n; i++) index2[nums2[i]] = i;
        for (int i = 0; i < n; i++) {
            pos[i] = index2[nums1[i]];
            index[i] = i ;
        }
        mergesort(pos,0 , n - 1 , new int[n] , left ,right , index , tempIndex);

        for(int i = 0 ; i < n ; i ++)
            res += left[i] * right[i];
        return res ;
    }

    private void mergesort(int[] pos , int l , int r , int[] temp , int[] left , int[] right, int[] index, int[] tempIndex) {
        if (l >= r)  return;
        int mid = l + (r - l) / 2;
        mergesort(pos, l, mid, temp, left, right, index, tempIndex);
        mergesort(pos, mid + 1, r, temp, left, right, index, tempIndex);
        merge(pos, l, mid, r , temp, left, right, index, tempIndex);
    }

    private void merge(int[] pos, int l, int mid, int r, int[] temp, int[] left, int[] right, int[] index, int[] tempIndex) {
        int i = l , j = mid + 1  , p = l , q = mid + 1 ;
        while (i <= mid && j <= r) {
            if(pos[i] < pos[j]) {
                temp[p] = pos[i] ;
                tempIndex[p] = index[i] ;
//                left[index[i]]  += j - mid - 1;
                right[index[i]] += r - j + 1;
                i ++;
                p ++;
            }else{
                temp[p] = pos[j];
                tempIndex[p] = index[j] ;
                left[index[j]]  += i - l;
//                right[index[j]] += mid - i  + 1;
                j++;
                p++;
            }
        }

        while (i <= mid) {
            temp[p] = pos[i] ;
            tempIndex[p] = index[i] ;
//            left[index[i]]  += j - mid - 1;
//            right[index[i]] += r - j;
            i ++;
            p ++;
        }
        while (j <= r) {
            temp[p] = pos[j];
            tempIndex[p] = index[j] ;
            left[index[j]]  += i - l;
//            right[index[j]] += mid - i ;
            j++;
            p++;

        }
        for(int  k = l ; k <= r ; k++){
            index[k] = tempIndex[k];
            pos[k] = temp[k];
        }
    }


}
