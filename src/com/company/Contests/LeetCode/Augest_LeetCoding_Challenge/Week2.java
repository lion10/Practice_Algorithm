package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.*;
import java.util.stream.Collectors;

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


    // Day 10: Excel Sheet Column Number
    /** Given a column title as appear in an Excel sheet, return its corresponding column number.
     */
    public int titleToNumber(String s) {
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            number *= 26;
            number += s.charAt(i) - 'A' + 1;
        }

        return number;
    }


    //  Day 11: H-Index
    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher,
     * write a function to compute the researcher's h-index.
     * According to the definition of h-index on Wikipedia: "A scientist has index
     * h if h of his/her N papers have at least h citations each,
     * and the other N − h papers have no more than h citations each."*/

    public int hIndex(int[] citations) {
        Integer[] input = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (a, b) -> b - a); // reverse order

        int start=0;
        int end=input.length-1;

        while(start<=end){

            int mid = start+ (end-start)/2;

            if(mid+1<=input[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }


    // Day 12: Pascal's Triangle II
    /**
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     * Note that the row index starts from 0.
     * */
    public List<Integer> getRow(int rowIndex) {

   /*     List<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
        list.add(new int[]{1,1});
        int i = 2;
        while (i <= rowIndex){
            int[] te = new int[i+1];
            te[0] = 1;
            te[i] = 1;
            for(int j = 0; j < i - 1 ;j++){
                te[j+1] = te[j] + te[j+1];
            }
            list.add(te);
            i++;
        }
        return  Arrays.stream(list.get(list.size()-1))     // IntStream
                .boxed()        // Stream<Integer>
                .collect(Collectors.toList());*/


        List<List> list = new ArrayList();
        List list1 = new ArrayList();
        list1.add(1);
        list.add(list1);
        for(int i = 1 ; i <= rowIndex ; i++){
            List<Integer> list2 = new ArrayList();
            List<Integer> list3 = list.get(i-1);
            list2.add(1);
            for(int j = 0 ; j < list3.size() -1 ; j++)
                list2.add(list3.get(j) + list3.get(j+1));
            list2.add(1);
            list.add(list2);
        }
        return list.get(list.size()-1);
    }



    // Day 13:  Iterator for Combination
    /** Design an Iterator class, which has:
     A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
     A function next() that returns the next combination of length combinationLength in lexicographical order.
     A function hasNext() that returns True if and only if there exists a next combination.
     */
    class CombinationIterator {

        ArrayList<String> list;
        int index;

        public CombinationIterator(String characters, int combinationLength) {
            list = new ArrayList<>();
            index = -1;

            createList(characters, combinationLength);
        }

        public String next() {
            index++;
            return list.get(index);
        }

        public boolean hasNext() {
            if(index+1 == list.size())      return false;
            return true;
        }

        public void createList(String characters, int combinationLength){

            int n = 0;
            while(true){
                StringBuilder sb = new StringBuilder();
                String s = Integer.toBinaryString(n);
                if(s.length() > characters.length())
                    return;

                if(isPerfectLength(n, combinationLength)){
                    int j = characters.length()-1;
                    for(int i=s.length()-1; i>=0; i--){
                        if(s.charAt(i) == '1'){
                            sb.append(characters.charAt(j));
                        }
                        j--;
                    }
                    list.add(0, sb.reverse().toString());
                }
                n++;
            }
        }

        public boolean isPerfectLength(int n, int combinationLength){
            int count = 0;

            while(n > 0){
                n = n & (n-1);
                count++;
            }

            if(count == combinationLength)
                return true;

            return false;
        }
    }

    // Day 14:  Longest Palindrome
    /** Given a string which consists of lowercase or uppercase letters, find the length of the
     *  longest palindromes that can be built with those letters.
     This is case sensitive, for example "Aa" is not considered a palindrome here.*/
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }

        if(!hs.isEmpty())
            return count * 2 + 1;

        return count*2;

    }
}
