package medium.A739;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, stackIndex = 0 ;
        int[] res =  new int[n]  , stack = new int [n];
        for(int i = 0 ; i < n ; i++){
            int t = temperatures[i];
            while(stackIndex != 0 && t > temperatures[stack[stackIndex - 1]]){
                stackIndex -- ;
                res[stack[stackIndex]] = i - stack[stackIndex];
            }
            stack[stackIndex++] = i;
        }
        return res;
    }
}
