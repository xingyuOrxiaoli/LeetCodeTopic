import java.util.Arrays;

class Solution {
    public int maximumScore(int[] cards, int cnt) {
        int n = cards.length , res = 0 , minOdd = 0 , minEven = 0 ;
        Arrays.sort(cards);
        for(int i = n - 1 ; i >= n - cnt ; i--) {
            if ((cards[i] & 1) == 1) {
                minOdd = cards[i];
            } else {
                minEven = cards[i];
            }
            res += cards[i];
        }
        if ((res & 1) == 1) {
            int maxOdd = 0 , maxEven = 0 , t = res;
            for (int i = 0 ; i < n - cnt ; i ++) {
                if ((cards[i] & 1) == 1) {
                    maxOdd = cards[i];
                } else {
                    maxEven = cards[i];
                }
            }
            // 删除奇数 添加 偶数
            int cur1 = 0;
            if (minOdd != 0 && maxEven != 0) {
                cur1 = t - minOdd + maxEven;
                res = cur1;
            }
            // 删除偶数 添加奇数
            if (minEven != 0 && maxOdd != 0) {
                if (minOdd != 0 && maxEven != 0) {
                    res = Math.max(res, t - minEven + maxOdd);
                } else {
                    res = t - minEven + maxOdd;
                }
            }
            if (t == res) {
                res = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().maximumScore(new int[]{9,5,9,1,6,10,3,4,5,1}, 2);
    }
}