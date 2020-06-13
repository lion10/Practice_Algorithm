package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.*;

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

    // Day 11
    /** Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note: You are not suppose to use the library's sort function for this problem.*/

    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }


    // Day 12

    /** Design a data structure that supports all following operations in average O(1) time.

     insert(val): Inserts an item val to the set if not already present.
     remove(val): Removes an item val from the set if present.
     getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.*/
    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list ;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }

            int index = map.remove(val);
            int lastItem = list.remove(list.size() - 1);
            if(val != lastItem) {
                list.set(index, lastItem);
                map.put(lastItem, index);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
