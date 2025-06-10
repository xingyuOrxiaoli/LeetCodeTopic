package simple.A3442;

public class 奇偶频次间的最大差值I {
    public static void main(String[] args) {
        int i = new 奇偶频次间的最大差值I().maxDifference("mmsmsym");
        System.out.println(i);
    }
    public int maxDifference(String s) {
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        int a1 = 0 , a2 = 200 ,  res = - 200;
        for (int i = 0; i < 26; i++) {
            if(dict[i] == 0) continue;
            if((dict[i] & 1) == 1) a1 = Math.max(a1, dict[i]);
            else a2 = Math.min(a2, dict[i]);
        }

        return a1 - a2;
    }
}
