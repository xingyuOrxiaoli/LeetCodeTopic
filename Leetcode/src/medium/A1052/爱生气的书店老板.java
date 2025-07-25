package medium.A1052;

public class 爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0 , sum = 0 , n = customers.length;

        for(int i  = 0 ; i < n ; i++)
            if(grumpy[i] == 0)
                sum += customers[i];
        for(int i = 0 ; i < minutes ; i ++)
            if(grumpy[i] == 1)
                sum += customers[i];
        res = sum;
        for(int i = minutes ; i < n ; i ++){
            if(grumpy[i - minutes] == 1) sum -= customers[i - minutes];
            if(grumpy[i] == 1) sum += customers[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
