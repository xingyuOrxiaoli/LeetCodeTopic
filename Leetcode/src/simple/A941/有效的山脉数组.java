package simple.A941;

public class 有效的山脉数组 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3) return false;
        boolean flag = false;
        for(int i = 1 ; i < n ; i ++){
            if(arr[i] == arr[i - 1]) return false;
            if(!flag){
                if(arr[i] > arr[i - 1]) continue;
                if(i == 1) return false;
                flag = true;
            }else {
                if(arr[i - 1] > arr[i]) continue;
                return false;
            }
        }
        return flag;
    }
}
