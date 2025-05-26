package medium.A130;

import java.util.*;

public class 被围绕的区域 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
//        board = new char[][]{
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'}
//        };

//        board = new char[][]{
//                {'O', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'O'},
//                {'X', 'X', 'O', 'X', 'O'}
//        };
        board = new char[][]{
                {'O','X','O','O','O','X'},
                {'O','O','X','X','X','O'},
                {'X','X','X','X','X','O'}, 
                {'O','O','O','O','X','X'},
                {'X','X','O','O','X','O'},
                {'O','O','X','X','X','X'}
    };
        board = new char[][]{
                {'X','O','X','O','X','O','O','O','X','O'},
                {'X','O','O','X','X','X','O','O','O','X'},
                {'O','O','O','O','O','O','O','O','X','X'},
                {'O','O','O','O','O','O','X','O','O','X'},
                {'O','O','X','X','O','X','X','O','O','O'},
                {'X','O','O','X','X','X','O','X','X','O'},
                {'X','O','X','O','O','X','X','O','X','O'},
                {'X','X','O','X','X','O','X','O','O','X'},
                {'O','O','O','O','X','O','X','O','X','O'},
                {'X','X','O','X','X','X','X','O','O','O'}
        };
        board = new char[][]{
                {'X','X','X','X','O','O','X','X','O'},
                {'O','O','O','O','X','X','O','O','X'},
                {'X','O','X','O','O','X','X','O','X'},
                {'O','O','X','X','X','O','O','O','O'},
                {'X','O','O','X','X','X','X','X','O'},
                {'O','O','X','O','X','O','X','O','X'},
                {'O','O','O','X','X','O','X','O','X'},
                {'O','O','O','X','O','O','O','X','O'},
                {'O','X','O','O','O','X','O','X','O'}
        };
        board = new char[][]{
                {'O','X','X','X','X','X','O','O'},
                {'O','O','O','X','X','X','X','O'},
                {'X','X','X','X','O','O','O','O'},
                {'X','O','X','O','O','X','X','X'},
                {'O','X','O','X','X','X','O','O'},
                {'O','X','X','O','O','X','X','O'},
                {'O','X','O','X','X','X','O','O'},
                {'O','X','X','X','X','O','X','X'}
        };
        new 被围绕的区域().solve4(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }




    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        int m = board.length ,n = board[0].length;
        if (m < 3 || n < 3)  return;

        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
                board[i][n - 1] = 'A';
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(new int[]{m - 1, i});
                board[m - 1][i] = 'A';
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= m || my >= n || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
                board[mx][my] = 'A';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }



    private class Position{
        private Integer x = 0;
        private Integer y = 0;

        public Position(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }
    // 暴力  有一组数据超时
    public void solve1(char[][] board) {
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
            System.out.println(board.length);
            System.out.println(board[0].length);
        }
        int[] dx = {-1 , 1 , 0, 0} , dy = {0 , 0 , -1, 1};
        int n = board.length , m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') continue;
                Set<Integer> set = new HashSet<>();
                if((i - 1 > -1 && board[i-1][j] == 'O') || (j - 1 > -1 && board[i][j-1] == 'O')) continue;
                Position position = new Position(i, j);
                Queue<Position> queue = new LinkedList<>();
                queue.add(position);
                boolean check = true;
                while (!queue.isEmpty() && check) {
                    Position p = queue.poll();
                    int x = p.getX();
                    int y = p.getY();
                    set.add(x * 201 + y);
                    for(int k = 0 ; k < 4 && check ; k ++){
                        if(x + dx[k] > -1 && x + dx[k] < n && y + dy[k] > -1 && y + dy[k] < m){
                            if(board[x + dx[k]][y + dy[k]] == 'X' || set.contains((x + dx[k]) * 201 + y + dy[k])) continue;
                            queue.add(new Position(x + dx[k], y + dy[k]));
                        }else check = false;
                    }
                }
                if(check) board[i][j] = 'X';
            }
        }
    }

    // 暴力 简单优化 超时
    public void solve2(char[][] board) {
//        for (char[] chars : board) {
//            System.out.println(Arrays.toString(chars));
//            System.out.println(board.length);
//            System.out.println(board[0].length);
//        }
        int[] dx = {-1 , 1 , 0, 0} , dy = {0 , 0 , -1, 1};
        int n = board.length , m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') continue;
                Set<Integer> set = new HashSet<>();
                if((i - 1 > -1 && board[i-1][j] == 'O') || (j - 1 > -1 && board[i][j-1] == 'O')) continue;
                Position position = new Position(i, j);
                Queue<Position> queue = new LinkedList<>();
                queue.add(position);
                boolean check = true;
                while (!queue.isEmpty() && check) {
                    Position p = queue.poll();
                    int x = p.getX();
                    int y = p.getY();
                    set.add(x * 201 + y);
                    for(int k = 0 ; k < 4 && check ; k ++){
                        if(x + dx[k] > -1 && x + dx[k] < n && y + dy[k] > -1 && y + dy[k] < m){
                            if(board[x + dx[k]][y + dy[k]] == 'X' || set.contains((x + dx[k]) * 201 + y + dy[k])) continue;
                            queue.add(new Position(x + dx[k], y + dy[k]));
                        }else check = false;
                    }
                }
                if(check){
                    set.forEach(value ->{
                        board[value / 201][value % 201] = 'X';
                    });
                }
            }
        }
    }
    // 暴力 简单优化2  超时
    public void solve3(char[][] board) {
//        for (char[] chars : board) {
//            System.out.println(Arrays.toString(chars));
//            System.out.println(board.length);
//            System.out.println(board[0].length);
//        }
        int[] dx = {-1 , 1 , 0, 0} , dy = {0 , 0 , -1, 1};
        int n = board.length , m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') continue;
                Set<Integer> set = new HashSet<>();
                if((i - 1 > -1 && board[i-1][j] == 'O') || (j - 1 > -1 && board[i][j-1] == 'O') || i == 0 || i == n -1 || j == 0 || j == m -1) continue;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i * 201 + j);
                boolean check = true;
                while (!queue.isEmpty() && check) {
                    int position = queue.poll();
                    int x = position / 201;
                    int y = position % 201;
                    set.add(x * 201 + y);
                    j = Math.max(j , y + 1);
                    for(int k = 0 ; k < 4 && check ; k ++){
                        if(x + dx[k] > -1 && x + dx[k] < n && y + dy[k] > -1 && y + dy[k] < m){
                            int newP = (x + dx[k]) * 201 + y + dy[k];
                            if(board[x + dx[k]][y + dy[k]] == 'X' || set.contains(newP)) continue;
                            queue.add(newP);
                        }else check = false;
                    }
                }
                if(check){
                    set.forEach(value ->{
                        board[value / 201][value % 201] = 'X';
                    });
                }
            }
        }
    }
    // 按照环序遍历
    public void solve4(char[][] board) {
        int n = board.length , m = board[0].length , end = (Math.min(n,m) + 1) >> 1;
        if(end <= 1) return;
        for(int i = 1 ; i < end ; i++){
            List<Integer> list = new ArrayList<>();
            // 一圈
            // 初始化
            if(board[i][i] != 'X' && board[i-1][i] == 'X' && board[i][i - 1] == 'X') board[i][i] = 'M';
            if(board[i][i] == 'O') list.add(i * 201 + i);
            int x = i , y = i + 1;
            // 顺时针
            while(!(x == i && y == i) && y <= m - i - 1){
                if(x == i && y != i && y < m - i - 1){
                    if(board[x][y] != 'X' && board[x - 1][y] != 'O') board[x][y] = 'M';
                    if(board[x][y] == 'O') list.add(x * 201 + y);
                    y ++;
                    if(y == m - 1 - i) {
                        if(board[x][y] != 'X' && board[x - 1][y] != 'O' && board[x][y + 1] != 'O') board[x][y] = 'M';
                        if(board[x][y] == 'O') list.add(x * 201 + y);
                        x ++;
                    }
                }else if(y == m - i - 1 && x < n - i - 1){
                    if(board[x][y] != 'X' && board[x][y + 1] != 'O') board[x][y] = 'M';
                    if(board[x][y] == 'O') list.add(x * 201 + y);
                    x ++;
                    if(x == n - 1 - i) {
                        if(board[x][y] != 'X' && board[x][y + 1] != 'O' && board[x + 1][y] != 'O') board[x][y] = 'M';
                        if(x == n - 1 - i && board[x][y] == 'O') list.add(x * 201 + y);
                        y --;
                    }

                }else if(x == n - 1 - i && y > i){
                    if(board[x][y] != 'X' && board[x + 1][y] != 'O') board[x][y] = 'M';
                    if(board[x][y] == 'O') list.add(x * 201 + y);
                    y --;
                    if(y == i) {
                        if(board[x][y] != 'X' && (board[x + 1][y] != 'O' && board[x][y - 1] != 'O') ) board[x][y] = 'M';
                        if(board[x][y] == 'O') list.add(x * 201 + y);
                        x --;
                    }
                }else if(y == i && x > i){
                    if(board[x][y] != 'X' && board[x][y -1] != 'O') board[x][y] = 'M';
                    if(board[x][y] == 'O') list.add(x * 201 + y);
                    x --;
                }
            }


            while (list.size() > 0){
                Integer value = list.get(0);
                int tempX = value / 201 , tempY = value % 201;
                if((tempX == i && tempY == i)) {
                    if(board[tempX][tempY + 1] == 'M') {
                        board[tempX][tempY + 1] = 'O';
                        list.add(tempX * 201 + tempY + 1);
                    }
                    if(board[tempX + 1][tempY] == 'M') {
                        board[tempX + 1][tempY] = 'O';
                        list.add((tempX + 1) * 201 + tempY);
                    }
                }else if((tempX == i && tempY == m - i - 1)){
                    if(board[tempX][tempY - 1] == 'M') {
                        board[tempX][tempY - 1] = 'O';
                        list.add(tempX * 201 + tempY - 1);
                    }
                    if(board[tempX + 1][tempY] == 'M') {
                        board[tempX + 1][tempY] = 'O';
                        list.add((tempX + 1) * 201 + tempY);
                    }
                }else if((tempX == n - i - 1  && tempY == m - i - 1)){
                    if(board[tempX][tempY - 1] == 'M') {
                        board[tempX][tempY - 1] = 'O';
                        list.add(tempX * 201 + tempY - 1);
                    }
                    if(board[tempX - 1][tempY] == 'M') {
                        board[tempX - 1][tempY] = 'O';
                        list.add((tempX - 1) * 201 + tempY);
                    }
                }else if((tempX == n - i - 1  && tempY == i)){
                    if(board[tempX][tempY + 1] == 'M') {
                        board[tempX][tempY + 1] = 'O';
                        list.add(tempX * 201 + tempY + 1);
                    }
                    if(board[tempX - 1][tempY] == 'M') {
                        board[tempX - 1][tempY] = 'O';
                        list.add((tempX - 1) * 201 + tempY);
                    }
                }else if(tempX == i || tempX == n - i - 1){
                    if(tempY - 1 >= i && board[tempX][tempY - 1] == 'M'){
                        board[tempX][tempY - 1] = 'O';
                        list.add(tempX * 201 + tempY - 1);
                    }
                    if(tempY <= m - i - 1 && board[tempX][tempY + 1] == 'M'){
                        board[tempX][tempY + 1] = 'O';
                        list.add(tempX * 201 + tempY + 1);
                    }
                }else if(tempY == i || tempY == m - i - 1){
                    if (tempX - 1 >= i && board[tempX - 1][tempY] == 'M'){
                        board[tempX - 1][tempY] = 'O';
                        list.add((tempX - 1) * 201 + tempY);
                    }
                    if (tempX + 1 <= n - i - 1 && board[tempX + 1][tempY] == 'M'){
                        board[tempX + 1][tempY] = 'O';
                        list.add((tempX + 1) * 201 + tempY);
                    }
                }
                list.remove(0);
            }
//            if(list.size() == 0){
//                for(int j = i ; j < n - i - 1; j ++)
//                    for(int k = i ; k < m - i - 1 ; k ++)
//                        board[j][k] = 'X';
//                break;
//            }else{
//
//                while (list.size() > 0){
//                    Integer value = list.get(0);
//                    int tempX = value / 201 , tempY = value % 201;
//                    if((tempX == i && tempY == i)) {
//                        if(board[tempX][tempY + 1] == 'M') {
//                            board[tempX][tempY + 1] = 'O';
//                            list.add(tempX * 201 + tempY + 1);
//                        }
//                        if(board[tempX + 1][tempY] == 'M') {
//                            board[tempX + 1][tempY] = 'O';
//                            list.add((tempX + 1) * 201 + tempY);
//                        }
//                    }else if((tempX == i && tempY == m - i - 1)){
//                        if(board[tempX][tempY - 1] == 'M') {
//                            board[tempX][tempY - 1] = 'O';
//                            list.add(tempX * 201 + tempY - 1);
//                        }
//                        if(board[tempX + 1][tempY] == 'M') {
//                            board[tempX + 1][tempY] = 'O';
//                            list.add((tempX + 1) * 201 + tempY);
//                        }
//                    }else if((tempX == n - i - 1  && tempY == m - i - 1)){
//                        if(board[tempX][tempY - 1] == 'M') {
//                            board[tempX][tempY - 1] = 'O';
//                            list.add(tempX * 201 + tempY - 1);
//                        }
//                        if(board[tempX - 1][tempY] == 'M') {
//                            board[tempX - 1][tempY] = 'O';
//                            list.add((tempX - 1) * 201 + tempY);
//                        }
//                    }else if((tempX == n - i - 1  && tempY == i)){
//                        if(board[tempX][tempY + 1] == 'M') {
//                            board[tempX][tempY + 1] = 'O';
//                            list.add(tempX * 201 + tempY + 1);
//                        }
//                        if(board[tempX - 1][tempY] == 'M') {
//                            board[tempX - 1][tempY] = 'O';
//                            list.add((tempX - 1) * 201 + tempY);
//                        }
//                    }else if(tempX == i || tempX == n - i - 1){
//                        if(tempY - 1 >= i && board[tempX][tempY - 1] == 'M'){
//                            board[tempX][tempY - 1] = 'O';
//                            list.add(tempX * 201 + tempY - 1);
//                        }
//                        if(tempY <= m - i - 1 && board[tempX][tempY + 1] == 'M'){
//                            board[tempX][tempY + 1] = 'O';
//                            list.add(tempX * 201 + tempY + 1);
//                        }
//                    }else if(tempY == i || tempY == m - i - 1){
//                        if (tempX - 1 >= i && board[tempX - 1][tempY] == 'M'){
//                            board[tempX - 1][tempY] = 'O';
//                            list.add((tempX - 1) * 201 + tempY);
//                        }
//                        if (tempX + 1 <= n - i - 1 && board[tempX + 1][tempY] == 'M'){
//                            board[tempX + 1][tempY] = 'O';
//                            list.add((tempX + 1) * 201 + tempY);
//                        }
//                    }
//                    list.remove(0);
//                }
//            }
        }


        int[] dx = {-1 , 1 , 0, 0} , dy = {0 , 0 , -1, 1};
        for(int i = 0 ; i < n ; i++)
            for (int j = 0 ; j < m ; j ++)
                if (board[i][j] !='X'){
                    for(int k  = 0 ; k < 4 ; k ++){
                        int x = i + dx[k] , y = j + dy[k];
                        if(x > -1 && x < n && y > -1 && y < m && board[x][y] == 'O'){
                            board[i][j] = 'O';
                        }
                    }
//                    if(board[i][j] != 'O') board[i][j] = 'X';
                }
        for(int i = 0 ; i < n ; i++)
            for (int j = 0 ; j < m ; j ++)
                if (board[i][j] !='X'){
                    for(int k  = 0 ; k < 4 ; k ++){
                        int x = i + dx[k] , y = j + dy[k];
                        if(x > -1 && x < n && y > -1 && y < m && board[x][y] == 'O'){
                            board[i][j] = 'O';
                        }
                    }
                    if(board[i][j] != 'O') board[i][j] = 'X';
                }
    }
}
