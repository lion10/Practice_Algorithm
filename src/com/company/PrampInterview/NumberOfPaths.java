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

/*    static int[][] grid ;

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
        if( row > lengthRow/2 || col> lengthCol/2 || row < 0 || col < 0)
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



    public static boolean isValid1(int row ,int col,int  ROW, int COL){
        if(row > ROW/2 || col> COL/2 || row < 0 || col <0 ){
            return false;
        }
        return true;
    }*/


    // not optimal solution => time limit exccededd
    static int numOfPathsToDest1(int n) {

        // your code goes here
        int[][] memo = new int[n][n];
        for(int i = 0 ;i < n ;i++){
            for(int j = 0;j < n ; j++ ){
                memo[i][j] = -1;
            }
        }
        return numOfPathsToSquare(n-1,n-1,memo);
    }
    static int numOfPathsToSquare(int i ,int j,int[][] memo){
        if (i < 0 || j < 0)
            return 0;
        else if(i < j)
            memo[i][j] = 0;
        else if(i == 0 && j == 0)
            memo[i][j] = 1;
        else{
            // (i , j-1) one step north
            // (i-1 , j) one step east
            memo[i][j] = numOfPathsToSquare(i,j-1,memo) +
                    numOfPathsToSquare(i-1,j,memo);
        }
        return memo[i][j];

    }



    // best solution O(n^2), space complexity is reduced to O(n)
    static int numOfPathsToDest2(int n) {
        if (n == 1)
            return 1;

        int[] lastRow = new int[n];
        for(int i=0; i < n ;i++)
            lastRow[i] = 1; // base case - the first row is all ones


        int[] currentRow = new int[n];
        for (int j=1; j < n ;j++){
            for (int i=j; i < n ;i++){
                if (i == j)
                    currentRow[i] = lastRow[i];
                else
                    currentRow[i] = currentRow[i-1] + lastRow[i];
            }
            lastRow = currentRow;
        }
        return currentRow[n-1];
    }


    public static void main(String[] args) {

    }

    public static void test(int n){
        for (int i = 0; i <n ; i++) {
                if(i % 3 == 0 && i%5==0)
                    System.out.println("FizzBuzz");
                else if(i % 3 == 0 && i%5!=0 )
                    System.out.println("Fizz");
                else if (i % 5 == 0 && i%3!=0)
                    System.out.println("Buzz");
                else if (i % 5 != 0 || i%3!=0)
                    System.out.println("Buzz");
        }
    }
}
