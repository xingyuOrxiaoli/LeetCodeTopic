package simple.A463;

public class A463SolutionMethodV1  implements A463Solution{

    @Override
    public int islandPerimeter(int[][] grid) {
        int res = 0 , n = grid.length , m = grid[0].length;
        int[] dx = new int[]{-1 , 0}, dy = new int[]{0 , -1};

        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 1) {
                    res += 4;
                    for(int k = 0; k < 2; k++) {
                        int x  = i + dx[k] , y = j + dy[k];
                        if(x > -1 && y > -1 && grid[x][y] == 1) {
                            res -= 2;
                        }
                    }
                }
            }
        }

        return res;
    }
}