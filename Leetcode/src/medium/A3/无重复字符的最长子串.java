package medium.A3;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        int i = new 无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        int[] arr = new int[128];
        int res = 0 ;
        int length = s.length();
        char[] ch = s.toCharArray(); // 参考1ms的答案的出来的加速方式
        int left = 0 ;
        for(int i = 0 ;i < length ; i++){
            if(arr[ch[i]] == 0 || arr[ch[i]] <= left){
                arr[ch[i]] = i + 1;
            }else{

                res = Math.max(res,i - left);
                left = arr[ch[i]];
                arr[ch[i]] = i + 1;
            }
        }

        res = Math.max(res,length - left);
        return res;
    }
}
