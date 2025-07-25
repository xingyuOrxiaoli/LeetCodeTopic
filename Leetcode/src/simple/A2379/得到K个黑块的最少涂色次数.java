package simple.A2379;

public class 得到K个黑块的最少涂色次数 {
    public static void main(String[] args) {
        int res = new 得到K个黑块的最少涂色次数().minimumRecolors("WBBWWBBWBW", 7);
        System.out.println(res);
    }
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length() , res = k , count = 0;
        for(int i = 0 ; i < k - 1; i ++)
            if(blocks.charAt(i) == 'W') count ++;
        for(int i = k - 1 ; i < n ; i ++){
            if(blocks.charAt(i) == 'W') count ++;
            res = Math.min(res, count);
            if(blocks.charAt(i - k + 1) == 'W') count --;
        }
        return res;
    }
}
