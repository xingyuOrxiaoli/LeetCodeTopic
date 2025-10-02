package medium.A3100;

public class 换水问题II {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;

        while(numBottles >= numExchange) {

            numBottles -= numExchange;

            numBottles ++;
            res ++ ;
            numExchange ++;
        }

        return res;
    }

}
