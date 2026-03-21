package simple.A3643;

public class A3643SolutionMethodV1  implements A3643Solution{

    @Override
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for(int i = 0 ; i < (k >> 1) ; i ++) {
            int x1 = x + i , x2 = x + k - 1 - i;
            for(int j = 0 ; j < k ; j ++) {
                int y1 = y + j;
                grid[x1][y1] = grid[x1][y1] ^ grid[x2][y1];
                grid[x2][y1] = grid[x2][y1] ^ grid[x1][y1];
                grid[x1][y1] = grid[x1][y1] ^ grid[x2][y1];
            }
        }
        return grid;
    }
}