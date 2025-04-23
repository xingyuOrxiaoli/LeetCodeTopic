package simple.A1399;

public class 统计最大组的数目 {

    public static void main(String[] args) {
        int i = new 统计最大组的数目().countLargestGroup(9999);

        System.out.println(i);
    }
    public int countLargestGroup(int n) {
        int[] st = new int[37];
        int max = 0 , res = 0;
        for (int i = 1; i <= n; i++) {
            int count =  sum(i);
            st[count] ++;
            max = Math.max(max, st[count]);
        }
        for(int i = 1 ; i < 37 ; i++)
            if(st[i] == max) res ++;
        return res;
    }
    private int sum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum ;
    }
}
