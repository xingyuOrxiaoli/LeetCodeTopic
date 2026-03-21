package simple.A1886;

public class A1886SolutionMethodV1  implements A1886Solution{

    @Override
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean zero = true , one = true , two = true , three = true;

        for(int x1 = 0 , y2 = n - 1; x1 < n && y2 > -1; x1 ++ , y2 --) {
            for(int y1 = 0 ,x2 = 0 ; y1 < n  && x2 < n; y1 ++ , x2 ++) {
                zero  &= mat[x1][y1] == target[x1][y1];
                one   &= mat[x1][y1] == target[x2][y2];
                two   &= mat[x1][y1] == target[n - x1 - 1][n - y1 - 1];
                three &= mat[x2][y2] == target[x1][x2];

                if(!(zero || one || two || three)) {
                    return false;
                }
            }
        }
        return true;
    }
}