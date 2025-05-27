package medium.A131;

import java.util.*;

public class 分割回文串 {
    public static void main(String[] args) {
        List<List<String>> res = new 分割回文串().partition("aab");
        res.forEach(list -> System.out.println(list));
    }



    List<List<String>> res  = new ArrayList<>();
    List<String> path =  new ArrayList<>();
    boolean[][] dp ;
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        for(int i = 0 ;i < n ; i++) Arrays.fill(dp[i], true);

        for(int i = n - 1; i > -1 ; i--)
            for(int j = i + 1 ; j < n ; j ++)
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j -1];
        dfs(s,0);
        return res;
    }

    private void dfs(String s, int i) {
        if(i == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i ; j < s.length() ; j++){
            if(dp[i][j]){
                path.add(s.substring(i,j+1));
                dfs(s,j+1);
                path.remove(path.size()-1);
            }
        }
    }

    // 暴力 不考虑重复校验的优化 就是当前串是回文串那么字串也是回文串
    // TODO 超时  "pppppppppp"
    public List<List<String>> partition1(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = i; j < n; j++) {
                str += s.charAt(j) ;
                if(check(str)) res.add(str);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            int j = 0 , end = list.size() ;
            while(j != end ){
                int len1 = list.get(j).length() , len2 = res.get(i).length();
                if( len1 + len2 <= s.length() &&  (list.get(j) + res.get(i)).equals(s.substring(0,len1 + len2))){
//                    ans.get(j).add(res.get(i));
                    List<String> tem = new ArrayList<>(ans.get(j));
                    tem.add(res.get(i));
                    ans.add(tem);
                    list.add(list.get(j) + res.get(i));
//                    list.remove(0);
//                    j -- ;
//                    end --;
                }
                j ++;
            }
            ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(res.get(i));
            list.add(res.get(i));
        }
        Iterator<List<String>> iterator = ans.iterator();
        TreeSet<Integer> set = new TreeSet<>();
        while(iterator.hasNext()){
            List<String> next = iterator.next();
//            System.out.println(next.toString().length());
            int elm = 0,sum = 0;
            for (String string : next) {
                elm = elm * 17 + string.length();
                sum += string.length();
            }

            if(sum != n || set.contains(elm)){
                iterator.remove();
            }
            if(sum == n ) set.add(elm);
        }
        return ans;
    }

    private boolean check(String str) {
        if(str.length() == 1) return true;
        int i = 0 , j = str.length() - 1;
        while (i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i ++;
                j --;
            }else return false;
        }
        return true;
    }
}
class Solution {
    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}
