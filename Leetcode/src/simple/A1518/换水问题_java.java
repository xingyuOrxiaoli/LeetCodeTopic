package simple.A1518;

public class 换水问题_java {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles >=numExchange){
            res += numBottles / numExchange;
            numBottles = numBottles % numExchange + numBottles / numExchange;
        }
        return res;
    }

}
