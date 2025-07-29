package medium.ALCR005;

public class 最大单词长度乘积 {
    public int maxProduct(String[] words) {
        int n = words.length , res = 0 ;
        int[] strBit = new int[n];
        for(int i = 0 ; i < n ; i++){
            for (char c : words[i].toCharArray()) {
                int bit = 1 << (c - 'a');
                if((bit & strBit[i]) != 0) continue;
                strBit[i] += bit;
            }
        }

        for(int i  = 0 ; i < n - 1; i ++){
            for(int j = i + 1 ; j < n ; j ++){
                if((strBit[i] & strBit[j]) == 0){
                    res = Math.max(res , words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
