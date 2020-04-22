package com.company.Contests.LeetCode;

import java.util.Arrays;
import java.util.List;

public class Week_3_leetCodeContest_30Days {

    public static void main(String[] args) {

        //14th day
      /*  int[] temp = productExceptSelf(new int[]{1,2,3,4});
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]+ " ");
        }
        */

        //15th day
       // System.out.println(checkValidString("(*))"));;


        //16th day

   /*     Scanner scan=new Scanner(System.in);


        char inputArray[][] = new char[4][5];

        for (int i = 0; i < 4; i++) {
            String data = "";
            if (scan.hasNext()) { // input from user
                data = scan.next();
            } else {
                break;
            }
            for (int j = 0; j < 5; j++)
                inputArray[i][j] = data.charAt(j);
        }

        System.out.println(numIslands(inputArray));*/

        //17th day
    /*    int[][] num = {  {1,3,1},
                        {1,5,1},
                        {4,2,1}};

        System.out.println(minPathSum(num));*/

        //18th day
       // System.out.println(search(new int[]{4,5,6,7,0,1,2},10));

        //19th day

        //20th day
        int[][] num = {
                {0,0,0,1},{0,0,1,1},{0,1,1,1}};
                System.out.println(leftMostColumnWithOne(num));

    }




    /**  14th day : Given an array nums of n integers where n > 1,
     *  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     **/

    // it takes o(n^2) and extra space o(n)
/*     public static int[] productExceptSelf(int[] nums) {
         int[] temp = new int[nums.length];
         Arrays.fill(temp, 1);
         int j = 0;
         while (j < nums.length){
             for (int i = 0; i < nums.length ; i++) {
                 if(i == j){
                     continue;
                 }else {
                     temp[j] *= nums[i];
                 }
             }
             j++;
         }

         return temp;
     }*/

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = rightProduct * ans[i];
            rightProduct *= nums[i];
        }
        return ans;
    }

    /**
     * 15th day :Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
     * An empty string is also valid.
     **/


    // not correct answer there some cases not accept it lol -_-
  /*  public static boolean checkValidString(String s) {
        Stack<Character> tracer = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            if ( s.charAt(i) == '(' ){
                tracer.push(s.charAt(i));
                System.out.printf("i = %d  tracer = %s \n",i,tracer.toString());
            } else{
                if(tracer.isEmpty()){
                    System.out.println("hack");
                    return false;
                }
                char lastValue = tracer.peek();
                if( (s.charAt(i)== ')' && lastValue == '(') ||  (s.charAt(i)== '*' && lastValue == '(') || (s.charAt(i)== '*' && lastValue == ')')) {
                    tracer.pop();
                   System.out.printf("i = %d  tracer = %s \n",i,tracer.toString());
                } else {
                    break;
                }
            }
        }
        return tracer.size() == 0 ;

    }*/


  // == >   (*)) solve it by Greedy  approach

    public static boolean checkValidString(String s) {
        int leftPer = 0, rightPer = 0;
        for (char ch: s.toCharArray()) {
            leftPer += (ch == '(' ? 1 : -1);
            rightPer += (ch != ')' ? 1 : -1);
            if (rightPer < 0) break;
            leftPer = Math.max(leftPer, 0);
        }
        return leftPer == 0;
    }

    /** 16th day:
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by wat*/

    public static int numIslands(char[][] grid) {

        int countOfIslands = 0 ;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if(grid[i][j] == '1'){
                    DFS(grid,i,j);
                    countOfIslands++;
                }
            }
        }
        return countOfIslands;
    }

    public static void DFS(char[][] grid , int row , int col){

        if(grid[row][col] == '0')
            return;

        grid[row][col] = '0';
         //   System.out.println("grid = " + Arrays.deepToString(grid) + ", row = " + row + ", col = " + col);
        if(row+1 < grid.length)
            DFS(grid,row+1,col);
        if(row-1 >=0)
            DFS(grid,row-1,col);
        if(col+1 <grid[0].length)
            DFS(grid,row,col+1);
        if(col-1 >= 0)
            DFS(grid,row,col-1);
    }

    /** 17th day:
     * Given a m x n grid filled with non-negative numbers,
     *  find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     **/


    // i solved it by dynamic programing approach technique

    public static int minPathSum(int[][] grid) {

        if (grid.length == 0) return 0;

        for (int row = 0; row <grid.length ; row++) {
            for (int col = 0; col <grid[0].length; col++) {
                if(row == 0 && col > 0 )
                    grid[row][col] += grid[0][col-1];
                else if(row > 0 && col == 0)
                    grid[row][col] += grid[row-1][0];
                else if(row > 0 && col > 0)
                    grid[row][col] += Math.min(grid[row][col-1],grid[row-1][col] );
            }
        }

        return  grid[grid.length-1][grid[0].length-1];
    }


    /** 18th day:
     *   Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *   (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *   You are given a target value to search. If found in the array return its index, otherwise return -1.
     *   You may assume no duplicate exists in the array.
     *   Your algorithm's runtime complexity must be in the order of O(log n).
     **/


    // in worst case it will take O(N)
    public static int search(int[] nums, int target) {
        int index ;
        for ( index = 0; index < nums.length; index++) {
            if(nums[index] == target)
                break;
        }
        return (index >=0 && index <= nums.length-1 )? index : -1;
    }


    /** 19th day:
     Return the root node of a binary search tree that matches the given preorder traversal.
     **/


    static class Soltution {
        int i =0;

       public  class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode(int x) { val = x; }
       }


       public  TreeNode bstFromPreorder(int[] preorder) {

           if(preorder == null || preorder.length == 0){
               return null;
           }

           return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
       }

       private TreeNode dfs(int[] preorder, int min, int max){
           if( i>=preorder.length){
               return null;
           }

           if(preorder[i]<min || preorder[i]>max){
               return null;
           }

           TreeNode root = new TreeNode(preorder[i]);
           i++;
           root.left = dfs(preorder, min, root.val);
           root.right = dfs(preorder, root.val, max);
           return root;
       }
   }






    /** 20th day:
                Leftmost Column with at Least a One
     **/

    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface BinaryMatrix {
     *     public int get(int x, int y) {}
     *     public List<Integer> dimensions {}
     * };
     */

    // this solution will take o(n * m) where n # of rows and m # of cols for array as parameter
    public static int leftMostColumnWithOne(int[][] binaryMatrix) {
        int col;
        int countOnesInCols= 0;
        for ( col = 0; col <binaryMatrix[0].length ; col++) {
            countOnesInCols = 0 ;

            for (int row = 0; row < binaryMatrix.length ; row++) {
                if(binaryMatrix[row][col] == 1){
                    countOnesInCols++;
                }
            }
            if(countOnesInCols == 1)
                break;
        }
        return countOnesInCols == 1 ? col : -1;
    }


    // this solution will take o(m * log(n)) where m # of rows and n # of cols for when parameter as interface
/*
    class Solution {
        int m , n ,leftMostColOne;
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            m = binaryMatrix.dimensions().get(0);
            n = binaryMatrix.dimensions().get(1);
            leftMostColOne = -1 ;
            binarySearch(binaryMatrix, 0, n-1);
            return leftMostColOne;
        }

        public void binarySearch(BinaryMatrix binaryMatrix, int start, int end){
            if (start > end){
                return;
            }
            int mid = start + (end - start / 2);
            if(allZerosBefourMid(binaryMatrix, mid)){
                binarySearch(binaryMatrix ,mid+1 , end);
            }else{
                leftMostColOne = mid;
                binarySearch(binaryMatrix ,start , mid-1);
            }
        }

        boolean allZerosBefourMid(BinaryMatrix binaryMatrix, int end){
            for(int i =0 ; i < m ; i++){
                if(binaryMatrix.get(i,end) == 1)
                    return false ;
            }
            return true;
        }


    }*/



}
