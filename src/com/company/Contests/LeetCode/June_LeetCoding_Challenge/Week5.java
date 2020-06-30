package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

public class Week5 {
    public static void main(String[] args) {

    }

    // Day 29 Unique paths
    /** A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
     corner of the grid (marked 'Finish' in the diagram below).*/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0) {
                    dp[i][j] =1;
                }else {
                    dp[i][j] += dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

