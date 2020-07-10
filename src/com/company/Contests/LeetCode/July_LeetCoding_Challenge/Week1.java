package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Week1 {
    public static void main(String[] args) {

    }
    // Day 1 Arranging Coins
    /** You have a total of n coins that you want to form in a staircase shape, where every k-th
     * row must have exactly k coins.
     Given n, find the total number of full staircase rows that can be formed.
     n is a non-negative integer and fits within the range of a 32-bit signed integer.*/
    public int arrangeCoins(int n) {
        int count = 0;
        for (int i = 1 ; i <=n ; i++){
            if ( n <= 0 )
                break;
            n -=i;
            count++;
        }
        return count;
    }



    // Day 2 Binary Tree Level Order Traversal II
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /** Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     *  (ie, from left to right, level by level from leaf to root).
     For example:
     Given binary tree [3,9,20,null,null,15,7],*/

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int count = q.size();
            while (count != 0){
                TreeNode temp = q.poll();
                list1.add(temp.val);
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
                count--;
            }
            list.add(list1);
        }
        Collections.reverse(list);
        return list;
    }

    // Day 3 Prison Cells After N Days

    /** There are 8 prison cells in a row, and each cell is either occupied or vacant.

     Each day, whether the cell is occupied or vacant changes according to the following rules:

     If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
     Otherwise, it becomes vacant.
     (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

     We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

     Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)*/

    public int[] prisonAfterNDays(int[] cells, int N) {
        N = (N-1) % 14 +1;
        for (int i = 0; i < N ; i++) {
            cells = newDay(cells);
        }
        return cells;

    }

    private int[] newDay(int[] cells) {
        int[] result = new int[cells.length];
        for (int i = 1; i < cells.length-1; i++) {
            result[i] = cells[i-1] == cells[i+1] ? 1 :0;
        }
        return result;
    }

    // Day 4 Ugly Number II
    /** Write a program to find the n-th ugly number.
     Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. */

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0]=1;
        int tow = 0 , three = 0 ,fife =0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[tow] * 2 , Math.min(dp[three] * 3, dp[fife] * 5));

            if (dp[i] == dp[tow] * 2 )
                tow++;
            if (dp[i] == dp[three] * 3 )
                three++;
            if (dp[i] == dp[fife] * 5 )
                fife++;
        }

        return dp[n-1];
    }

    // Day 5 Hamming Distance
    /** The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     Given two integers x and y, calculate the Hamming distance.*/

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // Day 6 Plus One

    /** Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

     The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

     You may assume the integer does not contain any leading zero, except the number 0 itself.*/
    public int[] plusOne(int[] digits) {
     int len = digits.length;
     // last item != 9
        if(digits[len-1] != 9){
            digits[len-1] = digits[len-1] + 1 ;
            return digits ;
        }
        // last item == 9
        for (int i = len -1; i >=0 ; i--) {
            digits[i] = ( digits[i] + 1 ) % 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        // num = 999
        int[]arr = new int[len+1];
        Arrays.fill(arr ,0);
        arr[0] = 1 ;
        return arr;

    }

    // Day 7 Island Perimeter
    /** You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

     Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

     The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1.
     The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.*/


    public int islandPerimeter(int[][] grid) {

        int perim = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    perim += surrounded(grid, i, j);
                }
            }
        }
        return perim;
    }
    public int surrounded(int[][] grid, int i, int j) {
        int surr = 0;
        if(i > 0 && grid[i - 1][j] == 1) {
            surr++;
        }
        if(j > 0 && grid[i][j - 1] == 1) {
            surr++;
        }
        if(i < grid.length - 1 && grid[i + 1][j] == 1) {
            surr++;
        }
        if(j < grid[i].length - 1 && grid[i][j + 1] == 1) {
            surr++;
        }
        return (4 - surr);
    }


}
