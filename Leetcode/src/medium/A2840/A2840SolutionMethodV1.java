package medium.A2840;

public class A2840SolutionMethodV1  implements A2840Solution{

    @Override
    public boolean checkStrings(String s1, String s2) {
        int[] odds = new int[26], evens = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if((i & 1) == 0) {
                odds[s1.charAt(i) - 'a']++;
            } else {
                evens[s1.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if((i & 1) == 0) {
                if(odds[c - 'a'] > 0) {
                    odds[c - 'a']--;
                } else {
                    return false;
                }
            } else {
                if(evens[c - 'a'] > 0) {
                    evens[c - 'a']--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}