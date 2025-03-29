package difficulty.A2360;

public class 图中的最长环 {
    public static void main(String[] args) {
        int[] edges = new int[]{3,3,4,2,3};
        int i = new 图中的最长环().longestCycle(edges);
        System.out.println(i);
    }
    public int longestCycle(int[] edges) {
        int length = edges.length;
        int[] st = new int[length];
        int res = -1;
        int cur = 0;

        for (int i = 0; i < length; i++) {
            if(st[i] != 0) {
                continue;
            }
            int temp = i , start = cur;
            while(temp != -1) {
                cur ++;
                if(st[temp] != 0){
                    if(st[temp] > start){
                        res = Math.max(res,cur - st[temp]);
                    }
                    break;
                }
                st[temp] = cur;
                temp = edges[temp];
            }
        }
        return res;
    }
}
