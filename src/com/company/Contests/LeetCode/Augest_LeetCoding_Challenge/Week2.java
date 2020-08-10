package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.LinkedList;
import java.util.Queue;

public class Week2 {


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

    //Day 8 :  Path Sum III

    /** You are given a binary tree in which each node contains an integer value.
     Find the number of paths that sum to a given value.
     The path does not need to start or end at the root or a leaf, but it must
     go downwards (traveling only from parent nodes to child nodes).
     The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     */

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int cur = process(root,sum);
        return cur + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    private int process(TreeNode root,int remain){
        if(root == null) return 0;
        int cur = 0;
        if(root.val == remain) cur = 1;
        return cur + process(root.left,remain - root.val) + process(root.right,remain -root.val);
    }




    //Day 9 : Rotting Oranges

    /** In a given grid, each cell can have one of three values:
     the value 0 representing an empty cell;
     the value 1 representing a fresh orange;
     the value 2 representing a rotten orange.
     Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
     Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     If this is impossible, return -1 instead.
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        //add all the rotten orange coordinate to queue
        //also, set rotten orange coordinate to 0 so we won't visit it again
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 0;
                }
            }
        }
        int stepCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] currCoord = queue.remove();
                int currRow = currCoord[0];
                int currCol = currCoord[1];
                if (currRow+1 < grid.length && grid[currRow+1][currCol] == 1) {
                    grid[currRow+1][currCol] = 0;  //set to 0 so we won't visit it again
                    queue.add(new int[]{currRow+1, currCol});
                }
                if (currRow-1 >= 0 && grid[currRow-1][currCol] == 1) {
                    grid[currRow-1][currCol] = 0;
                    queue.add(new int[]{currRow-1, currCol});
                }
                if (currCol+1 < grid[currRow].length && grid[currRow][currCol+1] == 1) {
                    grid[currRow][currCol+1] = 0;
                    queue.add(new int[]{currRow, currCol+1});
                }
                if (currCol-1 >= 0 && grid[currRow][currCol-1] == 1) {
                    grid[currRow][currCol-1] = 0;
                    queue.add(new int[]{currRow, currCol-1});
                }
                size--;
            }
            stepCount++;
        }
        //do we still have any fresh oranges in the grid
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {
                if (grid[m][n] == 1) {
                    return -1;
                }
            }
        }
        //-1 because first iteration is all rotten oranges from the initial state
        return Math.max(0, stepCount-1);
    }
}
