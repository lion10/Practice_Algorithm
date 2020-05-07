package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

import javax.swing.*;
import java.util.HashMap;


public class Week_1_LeetCodeContest_May_30Days {

    public static void main(String[] args) {

        //day 2
        //System.out.println(numJewelsInStones("aA","aAAbbbb"));

        //day 3
        //System.out.println(canConstruct("a", "b"));

        //day 4
        //System.out.println(findComplement(10));

        //day 5
      //  System.out.println(firstUniqChar("loveleetcode"));

        //day 6
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));

    }
    // Day1
    /**
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
     * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
     *Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
     * You should minimize the number of calls to the API.
     * */

    ///////// 1st solution is correct but  Time Limit Exceeded
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      /*  public class Solution extends VersionControl {
            public int firstBadVersion(int n) {
                int min = Integer.MAX_VALUE;
                for(int i =1 ;i <= n ;i++){
                    if(isBadVersion(i))
                        min =Math.min(min,i);
                }
                return min;
            }
        }
    */


      /////////2nd solution by binary search algorithm it takes o(log n)

//    public int firstBadVersion(int n) {
//        int left = 1;
//        int right = n;
//        while(left < right){
//            int mid = left + (right - left) / 2;
//            if(isBadVersion(mid)){  // from API , That's already found in questions so i can't implement it here
//                right= mid ;
//            }else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }





    // Day2
    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character
     * in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
     * so "a" is considered a different type of stone from "A".
     * */

    public static int numJewelsInStones(String J, String S) {

        /*
                int count = 0;

                for (int i = 0; i <J.length() ; i++) {
                    for (int j = 0; j < S.length() ; j++) {
                        if(J.charAt(i) == S.charAt(j))
                            count++;
                    }
                }

                return count;
        */


        // optimize 1st solution
        int count =0;
        for(char c : S.toCharArray()){
            if(J.indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }


    // Day3

    /**
     * Given an arbitrary ransom note string and another string containing letters from all the magazines,
     * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise,
     * it will return false.
     * Each letter in the magazine string can only be used once in your ransom note.*/


    public static boolean canConstruct(String ransomNote, String magazine) {
        // pending solution
    /*    if( (ransomNote.length() == 0 && magazine.length() == 0) || (ransomNote.length() == 0 && magazine.length() > 0))
            return true;
        if((ransomNote.length() > 0 && magazine.length() == 0))
            return false;

        int count = 0;
        for (int i = 0; i <ransomNote.length() ; i++) {
            for (char j: magazine.toCharArray()) {
                if(ransomNote.charAt(i) == j){
                    count++;
                }else if(count == ransomNote.length()){
                    return true;
                }
                else {
                    count = 0;
                }
            }
        }

        return false;*/

     // using string builder O(n)
        StringBuilder stringBuilder = new StringBuilder().append(magazine);
        int length = ransomNote.length();
        int count = 0;
        for(int i = 0 ; i < length ; i++){
            int index = stringBuilder.indexOf(ransomNote.charAt(i)+"");
            if(index != -1){
                stringBuilder.delete(index, index+1);
                count++;
            }
        }
        if(count == length){
            return true;
        }
        return false;
    }

    // Day4

    /**
     *Given a positive integer, output its complement number. The complement strategy is to flip the bits of
     * its binary representation.*/

    public static int findComplement(int num) {
        // time limited exceeded
/*        String numToBinary = Integer.toBinaryString(num);
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i <numToBinary.length() ; i++) {
            if(numToBinary.charAt(i) == '1')
                temp.append('0');
            else
                temp.append('1');
        }
        int binaryNumber   = Integer.parseInt(String.valueOf(temp));
        int result =0 ;
        int power = 0;
        while (true){
            if(binaryNumber  == 0 )
                break;
            else {
                int test = binaryNumber %10;
                result += test * Math.pow(2,power);
                binaryNumber/=10;
                power++;
            }
        }
        return result;*/

        if (num == 0 )
            return 1;
        if ((num & (num+1)) == 0)
            return 0;

        int log2 = 31 - Integer.numberOfLeadingZeros(num); // 32 -(leading zeros) == > 31 - (32 - 4) = 3
        System.out.println("log2 = " + log2);
        long x = (long) (Math.pow(2, log2 + 1) - 1L); // 16 -  1 = 15
        System.out.println("x = " + x);

        return (int) ( x - num );
    }

    // Day 5

    /** Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     */

    public static int firstUniqChar(String s) {

        if(s.length() == 0 ){
            return -1;
        }
        HashMap<Character,Integer> hashMap =  new HashMap<>();
        for (char charInString: s.toCharArray()) {
            if(!hashMap.containsKey(charInString)){
                hashMap.put(charInString,1);
            }else {
                hashMap.put(charInString,hashMap.get(charInString)+1);
            }
        }
        // System.out.println("hashMap = " + hashMap);

        int count = 0;
        for (char charInString: s.toCharArray()) {
            if(hashMap.get(charInString) == 1){
                break;
            }
            count++;
        }
        return count == s.length() ? -1 : count;

    }


    // Day 6

    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than
     * ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element always exist in the array.*/

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int result =0;
        for (int  num: nums) {
            if(hashMap.get(num) > max){
                max = Math.max(max , hashMap.get(num) ) ;
                result =num;
            }
        }
        return result;
    }


    //day 7
    /**
     * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
     * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
     * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
     * Return true if and only if the nodes corresponding to the values x and y are cousins.
     **/

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
/**
     public boolean isCousins(TreeNode root, int x, int y) {

         TreeNode nodeX =  new TreeNode(x);
         TreeNode nodeY =  new TreeNode(y);

         return (level(root,nodeX ,1) == level(root,nodeY,1)) && (!isSibling(root,nodeX,nodeY));
     }

    private boolean isSibling(TreeNode root, TreeNode nodeX, TreeNode nodeY) {
        if(root == null)
            return false;
        return (root.left == nodeX && root.right == nodeY) ||
                (root.left == nodeY && root.right == nodeY) ||
                isSibling(root.right,nodeX,nodeY)||
                isSibling(root.left,nodeX,nodeY);
    }

    private int level(TreeNode root, TreeNode node, int level) {
        if(root == null)
            return 0 ;
        if(root == node )
            return level;

        int lev = level(root.left,node,level+1);
        if(lev != 0)
            return lev;

        return level(root.right,node,level+1);
    }

    */

    class Pair{
        TreeNode parent;
        int level;

        Pair(TreeNode parent, int level){
            this.parent = parent;
            this.level = level;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Pair pair1 = countLevel(root, x, null, 0);
        Pair pair2 = countLevel(root, y, null, 0);
        if(pair1.level == pair2.level && pair1.parent != pair2.parent){
            return true;
        }
        return false;
    }

    Pair countLevel(TreeNode root, int val, TreeNode parent, int level){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return new Pair(parent, level);
        }

        Pair leftPair = countLevel(root.left, val, root, level + 1);
        Pair rightPair = countLevel(root.right, val, root, level + 1);
        return leftPair == null ? rightPair : leftPair;
    }
}
