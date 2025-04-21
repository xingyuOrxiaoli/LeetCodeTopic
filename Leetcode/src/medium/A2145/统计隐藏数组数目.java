package medium.A2145;

public class 统计隐藏数组数目 {

    public static void main(String[] args) {
        int[] differences = {1,-3,4};
        int i = new 统计隐藏数组数目().numberOfArrays(differences, 1, 6);
        System.out.println(i);
    }
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = Math.min(0 , differences[0]) , max = Math.max(0 , differences[0]), n  = differences.length;
        int res = upper - lower + 1;
        for(int i = 1 ; i < n ; i++){
            res = res - max + min;
            if(res < 0) return 0;
            differences[i] = differences[i-1] + differences[i];
            min = Math.min(min, differences[i]);
            max = Math.max(max, differences[i]);

        }
        if(res < 0) res = 0;
        return res;
    }
}
