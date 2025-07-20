package simple.A2469;

public class 温度转换 {
    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0] = celsius + 273.15;
        res[1] = celsius * 1.80 + 32.0;
        return res;
    }
}
