package medium.A134;

import javafx.scene.chart.ValueAxis;
import utils.ArrayUtils;

public class 加油站 {
    public static void main(String[] args) {

        int[] gas = ArrayUtils.createArrayOne("[1,2,3,4,5]");
        int[] cost = ArrayUtils.createArrayOne("[3,4,5,1,2]");
        int i = new 加油站().canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    // 暴力接
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
//        int[] value = new int[n];
//        for(int i = 0 ; i < n ; i ++) value[i] = gas[i] - cost[(n - i  + i ) % n];
        for(int i = 0 ; i < n ; i ++){
            int gasT = 0 , costT = 0 ;
            int m = 0;
            while(m < n){
                int j = (i + m) % n;
                gasT += gas[j];
                costT += cost[j];
                if(gasT < costT)break;
                m ++;
            }
            if(m == n) return i;
            else i = i + m ;
        }
        return -1;
    }
}
