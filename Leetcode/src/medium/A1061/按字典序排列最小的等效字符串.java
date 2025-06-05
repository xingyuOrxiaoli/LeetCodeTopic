package medium.A1061;

public class 按字典序排列最小的等效字符串 {

    public static void main(String[] args) {
        String s = new 按字典序排列最小的等效字符串().smallestEquivalentString("leetcode", "programs", "sourcecode");
        System.out.println(s);
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] dict = new int[26];
        for(int i = 0; i < 26; i++) dict[i] = i;
        StringBuilder res = new StringBuilder();
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            int c1 = s1.charAt(i) - 'a' , c2 = s2.charAt(i) - 'a';

            while(dict[c1] != c1) c1 = dict[c1];
            while(dict[c2] != c2) c2 = dict[c2];

            if(c1 == c2) continue;

            if(c1 > c2) dict[c1] = c2;
            else dict[c2] = c1;

        }
        int m = baseStr.length();
        for(int i = 0; i < m; i++) {
            int c1 = baseStr.charAt(i) - 'a';
            while(dict[c1] != c1) c1 = dict[c1];
            res.append((char)(c1 + 'a'));
        }
        return res.toString();
    }

    // 并查集优化
    public String smallestEquivalentString2(String s1, String s2, String baseStr) {
        int[] dict = new int[26];
        for(int i = 0; i < 26; i++) dict[i] = i;
        StringBuilder res = new StringBuilder();
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            int c1 = s1.charAt(i) - 'a' , c2 = s2.charAt(i) - 'a';

            // 优化点 减少寻找父节点的过程
            while(dict[c1] != c1) {
                dict[c1] = dict[dict[c1]];
                c1 = dict[c1];
            }
            while(dict[c2] != c2) {
                dict[c2] = dict[dict[c2]];
                c2 = dict[c2];
            }

            if(c1 == c2) continue;

            if(c1 > c2) dict[c1] = c2;
            else dict[c2] = c1;

        }
        int m = baseStr.length();
        for(int i = 0; i < m; i++) {
            int c1 = baseStr.charAt(i) - 'a';
            while(dict[c1] != c1) c1 = dict[c1];
            res.append((char)(c1 + 'a'));
        }
        return res.toString();
    }
}
