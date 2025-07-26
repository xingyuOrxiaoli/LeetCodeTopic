package medium.A316;

public class 去除重复字母 {

    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        int n = s.length();
        for(int i = 0 ; i <  n ; i ++) count[s.charAt(i) - 'a']++;

        for(int i = 0 ; i < n ; i ++){
            char ch = s.charAt(i);
            if(!visited[ch - 'a']){
                while (res.length() > 0 && res.charAt(res.length()-1) > ch){
                    if(count[res.charAt(res.length() - 1) - 'a'] > 0){
                        visited[res.charAt(res.length()-1) - 'a'] = false;
                        res.deleteCharAt(res.length()-1);
                    }else break;
                }
                res.append(ch);
                visited[ch - 'a'] = true;
            }
            count[ch  - 'a'] --;
        }
        return res.toString();
    }
}
