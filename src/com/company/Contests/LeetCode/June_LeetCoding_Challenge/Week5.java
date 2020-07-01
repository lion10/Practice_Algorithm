package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    // Day 30:  Word Search II
    /**Given a 2D board and a list of words from the dictionary, find all words in the board.
     Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
     vertically neighboring. The same letter cell may not be used more than once in a word.*/

    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, List<int[]>> map = new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                List<int[]> nodes = map.getOrDefault(board[i][j], new ArrayList<>());
                nodes.add(new int[]{i, j});
                map.put(board[i][j], nodes);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String word : words){
            for(int[] pos : map.getOrDefault(word.charAt(0), new ArrayList<>())){
                if(containsWord(word, 1, pos[0], pos[1], board)){
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private boolean containsWord(String w, int idx, int x, int y, char[][] board){
        if(idx >= w.length()) return true;
        if(x < 0||y<0||x>=board.length||y>=board[0].length){
            return false;
        }
        char oldChar = board[x][y];
        board[x][y] = '#';
        boolean findMatch = false;
        for(int[] dir : dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX<0||newY<0||newX>=board.length||newY>=board[0].length||board[newX][newY]!=w.charAt(idx)){
                continue;
            }

            if(containsWord(w, idx+1, newX, newY, board)){
                findMatch = true;
                break;
            }
        }
        board[x][y] = oldChar;
        return findMatch;
    }
}

