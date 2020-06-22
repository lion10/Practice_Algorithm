package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.*;

public class Week3 {

    public static void main(String[] args) {

    }

    // Day 15
    /** Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST
     *  that the node's value equals the given value. Return the subtree rooted with that node.
     *  If such node doesn't exist, you should return NULL.*/
    public Week1.TreeNode searchBST(Week1.TreeNode root, int val) {
        return (root == null || root.val == val) ? root :
                ((root.val > val) ? searchBST(root.left, val) : searchBST(root.right, val));
    }

    // Day 16

    /** Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

     IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

     Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

     IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

     However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

     Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

     Note: You may assume there is no extra space or special characters in the input string.*/
    public String validIPAddress(String IP) {
        String result = "Neither";

        if(IP == null || IP.length() == 0 || IP.charAt(IP.length() - 1) == '.' || IP.charAt(IP.length() - 1) == ':')
            return result;

        /* validate for ipv4 */
        if(IP.contains(".")){

            String[] ipv4 = IP.split("[.]");

            if(ipv4.length > 4 || ipv4.length < 4 )
                return result;

            for(String ipv4Component : ipv4){

                /*checks if ipv4 contains numeric values only*/
                if(ipv4Component.matches("[0-9]+") == false || ipv4Component.length() > 4)
                    return result;

                /*checks for 0 - 255 range*/
                int ipv4ComponentNumeric = Integer.parseInt(ipv4Component);
                if(ipv4ComponentNumeric < 0 || ipv4ComponentNumeric > 255)
                    return result;

                /*checks for leading zero condition*/
                if(ipv4Component.length() > 1 && ipv4Component.charAt(0) == '0')
                    return result;
            }

            return "IPv4";

        } else if(IP.contains(":")){  /* validate for IPv6 */

            String[] ipv6 = IP.split(":");

            if(ipv6.length < 8 || ipv6.length > 8)
                return result;

            for(String ipv6Component : ipv6){
                /*checks for hexadecimal condition : a-f, A-F , 0-9*/
                if( ipv6Component.matches("[a-fA-F0-9]+") == false || ipv6Component.length() > 4)
                    return result;
            }
            return "IPv6";
        }
        return result;
    }

    //Day 17 Surrounded Regions

    /** Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

     A region is captured by flipping all 'O's into 'X's in that surrounded region.*/

    public void solve(char[][] board) {
        if(board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // traverse edge to turn O on edge and its relatives to *
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }

            if(board[i][cols-1] == 'O'){
                dfs(board, i, cols-1);
            }
        }

        for(int i = 0; i < cols; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }

            if(board[rows-1][i] == 'O'){
                dfs(board, rows-1, i);
            }
        }

        // flip O to X
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return;
        }

        if(board[row][col] == 'O')
            board[row][col] = '*';
        // top
        if(row-1 >= 0 && board[row-1][col] == 'O')
            dfs(board, row-1, col);
        // bottom
        if(row+1 < board.length && board[row+1][col] == 'O')
            dfs(board, row+1, col);
        // left
        if(col-1 >= 0 && board[row][col-1] == 'O')
            dfs(board, row, col-1);
        // right
        if(col+1 < board[0].length && board[row][col+1] == 'O')
            dfs(board, row, col+1);
    }




    //Day 18  H-Index II

    /** Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
     According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h
     papers have no more than h citations each." */

    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int i = n - 1;
        while( i >= 0 ) {
            if(citations[i] < n - i)
                break;
            i--;
        }
        return n - i - 1;
    }

    // Day 19

    /** Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
     *  (The occurrences may overlap.)
     Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring,
     the answer is "".)*/

    public String longestDupSubstring(String S) {
        int left = 0;
        int right = S.length() - 1;

        while (left < right) {
            int mid = left + ((right - left + 1) >> 1); // that's mean divide on 2 when the loop are iterated

            if (isDuplicatePresent(S, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return findDuplicate(S, left);
    }

    private boolean isDuplicatePresent(String S, int length) {
        if (length == 0)
            return true;

        return findDuplicate(S, length) != null;
    }

    private String findDuplicate(String S, int length) {
        long hash = 0;
        long prime = 29;
        long firstEntryPower = 1;
        for (int i = 0; i < length; i++) {
            firstEntryPower *= prime;
            hash = hash * prime + (S.charAt(i) - 'a');
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(hash, 0);

        for (int i = length; i < S.length(); i++) {
            hash = hash * prime + (S.charAt(i) - 'a');
            hash -= firstEntryPower * (S.charAt(i - length) - 'a');

            if (map.containsKey(hash)) {
                int index = map.get(hash);
                return S.substring(index, index + length);
            }

            map.put(hash, i - length + 1);
        }

        return null;
    }


    // Day 20 Permutation Sequence

    /** The set [1,2,3,...,n] contains a total of n! unique permutations.
     By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     Given n and k, return the kth permutation sequence.*/

    public String getPermutation(int n, int k) {

        List<Integer> numList = new LinkedList<>();
        // create the array of ints between 1 and n
        for (int i = 1; i <= n; i++)
            numList.add(i);

        // calculate factorial of the array numbers
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++)
            factorial[i] = i * factorial[i-1];

        // find the permutations
        k = k-1;
        StringBuilder permutation = new StringBuilder();
        for (int i = n; i > 0; i--){
            int index = k / factorial[i-1]; // index of current number
            k = k % factorial[i-1]; //the index for the remaining n-1 numbers
            permutation.append(numList.get(index));
            numList.remove(index);
        }

        return permutation.toString();

    }


    // Day 21 Dungeon Game


    /** The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

     The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

     Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

     In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

     Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

     For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path
     RIGHT-> RIGHT -> DOWN -> DOWN.*/

    //Time Limit Exceeded
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        return rec(0, 0, dungeon);
    }

    private int rec(int i, int j, int[][] dungeon) {
        if(i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;

        int health = Math.min(rec(i+1, j, dungeon), rec(i, j+1, dungeon));

        if(health == Integer.MAX_VALUE)
            health  = 1;

        int res = 0;
        if(health - dungeon[i][j] > 0)
            res = health - dungeon[i][j];
        else
            res = 1;

        return res;
    }


    // another way
    public int calculateMinimumHP2(int[][] dungeon) {
        int m = dungeon.length,n = dungeon[0].length;
        int[][]dp = new int[m+1][n+1];
        for(int i = 0 ; i <=m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[m][n - 1] =1;
        dp[m-1][n] = 1;

        for(int i = m-1; i>=0;i--){
            for(int j = n-1 ; j>=0 ; j--){
                int minHp = Math.min(dp[i + 1][j],dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = minHp < 1 ? 1 : minHp;
            }
        }
        return dp[0][0];
    }

}
