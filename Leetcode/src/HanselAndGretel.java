import java.io.*;
import java.util.Arrays;

public class HanselAndGretel {

    /**
     * Reads the maze file and returns a 2D boolean array.
     *
     * The file is expected to have an integer representing the dimension (dim)
     * of the maze, followed by dim*dim booleans which represent maze cells.
     * A true value indicates an explorable cell, while false indicates a wall.
     *
     * @param file the file path of the maze input file
     * @return a 2D boolean array representing the maze layout
     */
    public static boolean[][] readMaze(String file) {
        // DO NOT MODIFY THIS METHOD
        StdIn.setFile(file);
        int dim = StdIn.readInt();
        boolean[][] maze = new boolean[dim][dim];
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                maze[row][col] = StdIn.readBoolean();
            }
        }
        return maze;
    }

    /**
     * Recursively traverses the maze from the current position (row, col)
     * attempting to find a path to the exit (bottom-right corner).
     *
     * The method checks if the current cell is the exit. Otherwise, it attempts
     * to move to an adjacent cell (right, left, down, up) if that cell is open
     * and not yet visited. If no valid adjacent move is available, it calls
     * backtrack to search for alternative paths.
     *
     * @param maze        a 2D boolean maze where true indicates an open cell and false indicates a wall
     * @param breadcrumbs a 2D boolean array tracking visited positions
     * @param row         the current row in the maze
     * @param col         the current column in the maze
     * @return an integer array containing the coordinates {row, col} of the exit if found,
     *         or the starting cell if no exit exists
     */
    public static int[] takeStep(boolean[][] maze, boolean[][] breadcrumbs, int row, int col) {
        // WRITE YOUR CODE HERE
        if(row == maze.length-1 && col == maze[0].length-1){
            return new int[]{col, row};
        }
        if(row == 0 && col == 0 && !maze[row][col]){
            return new int[]{col, row};
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for(int i = 0; i < dx.length; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if( x >=0 && y >=0 && x < maze.length && y < maze[0].length  && maze[x][y] && !breadcrumbs[x][y]) {
                breadcrumbs[x][y] = true;
                int[] takeStep = takeStep(maze, breadcrumbs, x, y);
                if(takeStep[0] == maze.length - 1 && takeStep[1] == maze[0].length -1 ) return takeStep;
                breadcrumbs[x][y] = false;
            }
        }
        return new int[] {row, col};
    }

    /**
     * Backtracks from a dead-end to a previously visited cell that might have unexplored
     * neighbors. In the backtracking process, the current cell is marked as unvisited and
     * blocked, to ensure it is not considered again in the path search.
     *
     * The method checks the four adjacent cells (right, left, down, up) for visited cells,
     * and returns from the first valid backtracking move. If backtracking reaches the start
     * (and no moves remain), it outputs that no exit exists.
     *
     * @param maze        a 2D boolean maze where true indicates an open cell and false indicates a wall
     * @param breadcrumbs a 2D boolean array tracking visited positions
     * @param row         the current row in the maze
     * @param col         the current column in the maze
     * @return an integer array containing the current position {row, col} after backtracking,
     *         or {0, 0} if no exit can be found
     */
    public static int[] backtrack(boolean[][] maze, boolean[][] breadcrumbs, int row, int col) {
        // WRITE YOUR CODE HERE
        if(row == maze.length-1 && col == maze[0].length-1){
            return new int[]{col, row};
        }
        if(row == 0 && col == 0 && !maze[row][col]){
            return new int[]{col, row};
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < dx.length; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if( x >=0 && y >=0 && x < maze.length && y < maze[0].length  && maze[x][y] && !breadcrumbs[x][y]) {
                breadcrumbs[x][y] = true;
                int[] takeStep = backtrack(maze, breadcrumbs, x, y);
                if(takeStep[0] == maze.length - 1 && takeStep[1] == maze[0].length -1 ) return takeStep;
                breadcrumbs[x][y] = false;
            }
        }
        return new int[] {row, col};
    }


    /**
     * Writes the visited maze to the specified output file.
     *
     * The output file will begin with the maze's dimension (i.e., the number of rows)
     * followed by the 2D representation of the visited cells. Each cell is separated by
     * a space, and each row is written on a new line.
     *
     * @param visited a 2D boolean array where each element indicates whether
     *                the corresponding cell was visited (true) or not (false)
     * @param file    the file path where the visited maze should be written
     */
    public static void writeVisitedMaze(boolean[][] visited, String file) {
        // WRITE YOUR CODE HERE
        StdOut.setFile(file);
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            for (boolean[] row : visited) {
                for (int j = 0; j < row.length; j++) {
                    out.print(row[j]);
                    out.print(" ");
                }
                out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing maze to file: " + file, e);
        }
    }

    /**
     * The main entry point for the Hansel and Gretel maze traversal program.
     *
     * This method:
     * 1. Reads a maze from the specified input file
     * 2. Attempts to find a path from the top-left cell (0,0) to the bottom-right cell
     * 3. Tracks which cells were visited during the traversal
     * 4. Writes the visited cells to the specified output file
     *
     * The program expects exactly two command-line arguments:
     * - The path to the input file containing the maze definition
     * - The path to the output file where the visited cells will be written
     *
     * @param args command line arguments containing input and output file paths
     */
    public static void main(String[] args) {
        // We expect two arguments: the input file and the output file
        // This prevents your program from crashing when there is a mismatch in the number of arguments
        // DO NOT MODIFY THIS CONDITIONAL STATEMENT
        if (args.length != 2) {
            System.out.println("Usage: java HanselAndGretelReference <inputfile> [outputfile]");
            return;
        }
        boolean[][] maze = readMaze(args[0]);
        boolean[][] visits = new boolean[maze.length][maze[0].length];
        visits[0][0] = maze[0][0];
        takeStep(maze, visits, 0, 0);
        if(visits.length == 1 && visits[0].length == 1) visits[0][0] = true;
        // WRITE YOUR CODE HERE
        writeVisitedMaze(visits, args[1]);
    }
}
