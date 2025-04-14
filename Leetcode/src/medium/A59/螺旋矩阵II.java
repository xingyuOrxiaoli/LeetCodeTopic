package medium.A59;

public class 螺旋矩阵II {
    public static void main(String[] args) {
        for(int index = 1 ; index < 11 ; index ++) {

            System.out.println(" ============== " + index + " ==============");
            int[][] ints = new 螺旋矩阵II().generateMatrix(index);
            for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints[0].length; j++) {
                    System.out.print(ints[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0 , j = 0 , num = 1 , floor = 0 ;
        while(res[i][j] == 0){
            res[i][j] = num ++;
            if(floor == i && j < n - floor - 1) j ++;
            else if(j == n - floor - 1 && i < n - floor - 1) i ++;
            else if(i == n - floor - 1 && j > floor) j --;
            else if(j == floor && i > floor){
                i -- ;
                if( i == floor + 1) floor ++ ;
            }
        }
        return res;
    }
}
