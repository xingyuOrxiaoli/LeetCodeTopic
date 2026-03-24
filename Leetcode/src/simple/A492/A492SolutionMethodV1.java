package simple.A492;

public class A492SolutionMethodV1  implements A492Solution{

    @Override
    public int[] constructRectangle(int area) {
        int[] res = new int[2];

        for (int i = 1; i <= Math.sqrt(area); i++) {
            if(area % i == 0) {
                res[0] = area / i;
                res[1] = i;
            }
        }
        return res;
    }
}