package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

public class Week2 {
    public static void main(String[] args) {

    }

    // Day 8

    /**
     *  Given an integer, write a function to determine if it is a power of two.
     */
    //  Time Limit Exceeded
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < n ; i++) {
            if(n == Math.pow(i,2))
                return true;
        }
        return false;

    }

    public boolean isPowerOfTwo1(int n) {
        return (n>0 && ((n & (n-1)) == 0));
    }




    // Day 9
    /** Given a string s and a string t, check if s is subsequence of t.
     A subsequence of a string is a new string which is formed from the original string by deleting some
     (can be none) of the characters without disturbing the relative positions of the remaining characters.4
     (ie, "ace" is a subsequence of "abcde" while "aec" is not).*/
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length())
            return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1)
                return false;
            prev++;
        }
        return true;

    }
    // Day 10

    /** Given a sorted array and a target value, return the index if the target is found. If not,
     * return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.*/


    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] >= target ){
                return i;
            }
        }
        return target > nums[index] ? nums.length : index;

    }


}
