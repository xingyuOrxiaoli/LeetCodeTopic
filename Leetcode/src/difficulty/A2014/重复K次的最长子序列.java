package difficulty.A2014;

public class 重复K次的最长子序列 {
    public static void main(String[] args) {
    }

    char[] res ;
    int resLen;
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[chs                                                                                                  [i] - 'a']++;
        }
        StringBuilder temp = new StringBuilder();
        for(int i = 25 ; i > -1 ; i --){
            String str = (char)('a' + i) +"";
            for(int j = 0 ; j < counts[i] / k ; j ++){
                temp.append(str);
            }
        }
        char[] t = temp.toString().toCharArray();

        res = new char[t.length];

        permute(t,k,chs);

        return "";
    }

    // 全排列
    // 枚举从nums中选任意个数的所有排列
    private void permute(char[] nums, int k, char[] chs) {
        int n = nums.length;
        char[] path = new char[n];
        boolean[] visited = new boolean[n];
        dfs(0 , nums,path,visited,k ,chs);
    }

    private void dfs(int index, char[] nums, char[] path, boolean[] visited, int k, char[] chs) {

        if(index == nums.length) return;

//        for()


    }
}
