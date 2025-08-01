package medium.A2683;

public class 相邻值的按位异或 {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        for(int i = 0 ; i < 2 ; i ++){
            int cur = i;
            for(int j = 0 ; j < n; j ++){
                if(j == n - 1){
                    if((cur ^ i) != derived[j]) break;
                    else return true;
                }else cur = cur ^ derived[j];
            }
        }
        return false;
    }
    public boolean doesValidArrayExist1(int[] derived) {
        int res = 0;
        for (int value : derived) res ^= value;
        return res == 0;
    }
}
