package simple.A605;

public class A605SolutionMethodV1  implements A605Solution{

    @Override
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for(int i = 0; i < m; i++) {
            if(flowerbed[i] == 1) {
                i ++;
                continue;
            }
            if(i == m - 1 || flowerbed[i + 1] == 0) {
                n --;
                flowerbed[i] = 1;
                i++;
            }
            if(n == 0) {
                return true;
            }
        }
        return n <= 0;
    }
}