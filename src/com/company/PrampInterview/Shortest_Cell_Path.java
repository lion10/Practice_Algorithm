package com.company.PrampInterview;
import java.util.LinkedList;
import java.util.Queue;


public class Shortest_Cell_Path {

    /*
    * Time Complexity: O(R*C), where R, C are the number of rows and columns in grid. We might visit every square in the grid
    *  It’s worth noting that typically in a breadth-first-search, the time complexity is O(V+E) where V = R * C is the
    *  number of nodes in the graph and E is the number of edges. Since E <= 4*V, this is O(V+E) = O(V) = O(R * C).
    * */
    /* Space Complexity: O(R*C), the space to store cells in queue and visited array.*/

    // all tests are passed 9/9
    // To store matrix cell coordinates

    static class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    };

    // A Data Structure for queue used in Breadth First Search
    static class queueNode {
        Cell cell; // The coordinates of a cell
        int distance; // cell's distance of from the source

        public queueNode(Cell pt, int dist) {
            this.cell = pt;
            this.distance = dist;
        }
    };

    // check whether given cell (row, col)
    // is a valid cell or not.
    static boolean isValid(int row, int col, int rowLength ,int colLength ) {
        // return true if row number and
        // column number is in range otherwise false
        return (row >= 0) && (row < rowLength) &&
                (col >= 0) && (col < colLength);
    }

    // These arrays are used to get row and column
    // numbers of 4 neighbours of a given cell

    static int rowNum[] = {-1, 0, 0, 1}; // indexes : 0 => left , 1 => down , 2 => top , 3 => right
    static int colNum[] = {0, -1, 1, 0}; // indexes : 0 => left , 1 => down , 2 => top , 3 => right

    // function to find the shortest path between
    // a given source cell to a destination cell.

    static int shortestCellPath(int grid[][], int sr, int sc, int tr, int tc) {
        Cell src = new Cell(sr,sc);
        Cell dest = new Cell(tr,tc);
        int rowLength = grid.length;
        int colLength= grid[0].length;
        // check source and destination cell
        // of the matrix have value 1
        if (grid[src.x][src.y] != 1 || grid[dest.x][dest.y] != 1)
            return -1;

        boolean [][]visited = new boolean[rowLength][colLength];

        // Mark the source cell as visited
        visited[src.x][src.y] = true;

        // Create a queue for BFS
        Queue<queueNode> q = new LinkedList<>();

        // Distance of source cell is 0
        queueNode s = new queueNode(src, 0);
        q.add(s); // Enqueue source cell

        // Do a BFS starting from source cell
        while (!q.isEmpty()) {
            queueNode curr = q.peek();
            Cell pt = curr.cell;

            // If we have reached the destination cell,
            // we are done
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.distance;

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            q.remove();

            // indexes : 0 => left , 1 => down , 2 => top , 3 => right
            for (int i = 0; i < 4; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                if (isValid(row, col,grid.length,grid[0].length) &&
                        grid[row][col] == 1 &&
                        !visited[row][col])
                {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode(new Cell(row, col),
                            curr.distance + 1 );
                    q.add(Adjcell);
                }
            }
        }

        // Return -1 if destination cannot be reached
        return -1;
    }
    public static void main(String[] args) {
        int mat[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        int distance = shortestCellPath(mat, 0,0,3,4);
        if (distance != Integer.MAX_VALUE)
            System.out.println("Shortest Path is " + distance);
        else
            System.out.println("Shortest Path doesn't exist");

    }
}


