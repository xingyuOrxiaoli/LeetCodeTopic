package simple.A28;

public class 找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        int i = new 找出字符串中第一个匹配项的下标().strStr("leetcode", "leeto");
        System.out.println(i);
    }
    // TODO 构造KMP  未通过
    public int KMP(String haystack, String needle ) {
        int length1 = haystack.length();
        int length2 = needle.length();
        int[] next = new int[length1 + 10];
        for(int i = 1 , j = 0 ; i < length2; i++){
            while(j != 0 && needle.charAt(i) != needle.charAt(j + 1)) j = next[j];
            if(needle.charAt(i) == needle.charAt(j + 1)) j ++;
            next[i] = j;
        }

        for(int i = 1, j = 0 ; i <= length1 - length2 + 1; i++){
            while(j != 0 && haystack.charAt(i) != needle.charAt(j + 1)) j = next[j];
            if(haystack.charAt(i) == needle.charAt(j + 1)) j ++;
            if(j == length2){
                return i;
            }
        }
        return -1;
    }
    // 暴力解 O(N∗M)
    public int strStr(String haystack, String needle) {
        int res = 0;
        int length1 = haystack.length();
        int length2 = needle.length();
        if(length1 < length2) return -1;
        while(res < length1 - length2 + 1){
            int i = res;
            int j = 0;
            while(j < length2){
                if(haystack.charAt(i++) == needle.charAt(j)){
                    j ++;
                }else{

                    break;
                }
            }
            if(j == length2){
                break;
            }
            res ++;
        }
        if(res ==  length1 - length2 + 1) res = -1;
        return res;
    }
}
