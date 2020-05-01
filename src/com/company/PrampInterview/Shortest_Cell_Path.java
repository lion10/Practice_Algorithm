package com.company.PrampInterview;


import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class Shortest_Cell_Path {


    /**
     * 3/9 cases are  passed
    * */
    private static class Cell{
        int x;
        int y;
        int dist;
        Cell prev;

        Cell(int x, int y, int dist, Cell prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }

        @Override
        public String toString(){
            return "("+x+ ","+y+")";
        }
    }
    //Time O(n^2), Space O(n^2)
    public static int print(int[][] grid, int sr, int sc, int tr, int tc) {
        if (grid[sr][sc] ==0 || grid[tr][tc] ==0)
            return 0;

        Cell[][] cells = new Cell[grid.length][grid[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (grid[i][j] != 0) {
                    cells[i][j] = new Cell(i, j, Integer.MAX_VALUE, null);
                }
            }
        }

        LinkedList<Cell> queue = new LinkedList<>();
        Cell src = cells[sr][sc];
        src.dist = 0;
        queue.add(src);
        Cell dest = null;
        Cell curr;
        while ((curr = queue.poll()) != null) {
            if (curr.x==tr&& curr.y == tc) {
                dest = curr;
            }
            visit(cells, queue, curr.x - 1, curr.y, curr);
            visit(cells, queue, curr.x + 1, curr.y, curr);
            visit(cells, queue, curr.x, curr.y - 1, curr);
            visit(cells, queue, curr.x, curr.y + 1, curr);
        }

        int count = 0;
        if (dest == null) {
            return 0;
        } else {
            LinkedList<Cell> path = new LinkedList<>();
            curr = dest;
            do {
                path.addFirst(curr);
                count++;
            } while ((curr = curr.prev) != null);
            //System.out.println(path);
        }

        return count;
    }

    static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent) {
        int dist = parent.dist + 1;
        if (x < 0 || x >= cells.length || y < 0 || y >= cells[0].length || cells[x][y] == null) {
            return;
        }
        Cell curr = cells[x][y];
        if (dist < curr.dist) {
            curr.dist = dist;
            curr.prev = parent;
            queue.add(curr);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(print(matrix, 2,4, 3,2));
    }

}


