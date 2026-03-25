package medium.A3546;

public class A3546SolutionMethodV1  implements A3546Solution{

    @Override
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int[] rows = new int[n] , cols = new int[m];
        long sum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
                sum += grid[i][j];
            }
        }

        if((sum & 1) == 1) {
            return false;
        }

        long rowSum = 0;
        for(int i = 0; i < n; i++){
            rowSum += rows[i];
            if(rowSum * 2 == sum) {
                return true;
            }
        }
        long colSum = 0;
        for(int j = 0; j < m; j++){
            colSum += cols[j];
            if(colSum * 2 == sum) {
                return true;
            }
        }

        return false;
    }
}