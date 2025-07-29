package medium.A318;

public class 最大单词长度乘积 {
    public static void main(String[] args) {
        String str = "fddddff";
        int res = 0;
        for (char c : str.toCharArray()) {
            int bit = 1 << (c - 'a');
            System.out.println(bit & res);
            if((bit & res) != 0) continue;
            res += bit;
        }
        System.out.println(res);
    }
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
