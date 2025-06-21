package medium.A3085;

import java.util.Arrays;

public class 成为K特殊字符串需要删除的最少字符数 {
    public static void main(String[] args) {
        int i = new 成为K特殊字符串需要删除的最少字符数().minimumDeletions("dabdcbdcdcd", 2);
        System.out.println(i);
    }
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[word.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        int res = Integer.MAX_VALUE , start = 0;

        for(int i = 0 ; i < 26 ; i ++){
            if(count[i] != 0) break;
            start ++;
        }

        for(int i = start ; i < 26 ; i ++){
            int temp = 0;
            for(int j = start ; j < i ; j++) {
                temp += count[j];
            }
            int max = count[i] + k;
            for(int j = i + 1 ; j < 26 ;j ++){
                if(max < count[j]) temp += (count[j] - max);
            }
            res = Math.min(res,temp);
        }

        return res;
    }
}
