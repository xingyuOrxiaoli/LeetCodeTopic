package simple.A1534;

public class 统计好三元组 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int i = new 统计好三元组().countGoodTriplets(arr, 7, 2,3);
        System.out.println(i);
    }
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n =  arr.length , res = 0 ;
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i + 1 ; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    if(Math.abs(arr[i] - arr[j] ) <=  a && Math.abs(arr[j] - arr[k]  ) <=  b && Math.abs(arr[i] - arr[k] ) <=  c) res ++;
                }
            }
        }
        return res;
    }
    private boolean check(int i , int j , int k ,int a , int b , int c){
        if(Math.abs(i - j ) <=  a && Math.abs(j - k  ) <=  b && Math.abs(i - k ) <=  c) return true;
        return false;
    }
}
