package com.company.PrampInterview;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfPaths {

         // 1/5 cases passed => next time i will solve it right
    /**You’re testing a new driverless car that is located at the Southwest (bottom-left)
     *  corner of an n×n grid. The car is supposed to get to the opposite, Northeast (top-right),
     *  corner of the grid. Given n, the size of the grid’s axes, write a function numOfPathsToDest that returns
     *  the number of the possible paths the driverless car can take.
    * */

    static int[][] grid ;

    static int rowTraverse[] = {0,0,0,1};  // index 0 => left, 1 = > down, 2 => top , 3 => right
    static int colTraverse[] = {0,0,1,0};


    static int numOfPathsToDest(int n ) {

        grid =  new int[n][n];

        Cell start = new Cell(n - 1,0);
        Cell destnation = new Cell(0,n-1);
        int colNum =n  ;
        int rowNum = n;

        boolean[][] visited = new boolean[n][n];
        visited[start.x][start.y] = true;

        Queue<Node> q = new LinkedList<>();
        Node s =  new Node(start,0);
        q.add(s);
        int countPaths = 0;

        while(!q.isEmpty()){

            Node curr = q.peek();
            Cell pt = curr.cell;

            if(pt.x == destnation.x && pt.y == destnation.y){
                countPaths++;
            }
            q.remove();
            for(int i = 0 ;i < 4 ; i++){
                int row = pt.x + rowTraverse[i];
                int col = pt.y + colTraverse[i];
                if(isValid1(row, col ,n,n) && !visited[row][col]) {
                    visited[row][col] = true;
                    Node adjCell = new Node(new Cell(row,col),curr.path+1);
                    q.add(adjCell);
                }
            }
        }
        return countPaths;
    }

    static boolean isValid1(int row , int col ,int lengthRow ,int lengthCol){
        if( row > lengthRow/2 || col> lengthCol/2 || row < 0 || col < 0 || row == col)
            return false;
        return true;
    }

    static class Cell{
        int x ;
        int y;
        Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        Cell cell;
        int path;
        Node(Cell cell, int path){
            this.cell= cell ;
            this.path =path;
        }
    }



    public static boolean isValid(int row ,int col,int  ROW, int COL){
        if(row > ROW/2 || col> COL/2 || row < 0 || col <0 ){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
