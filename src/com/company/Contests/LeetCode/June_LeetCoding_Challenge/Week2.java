package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.*;

public class Week2 {
    public static void main(String[] args) {

    }

    // Day 8

    /**
     * Given an integer, write a function to determine if it is a power of two.
     */
    //  Time Limit Exceeded
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < n; i++) {
            if (n == Math.pow(i, 2))
                return true;
        }
        return false;

    }

    public boolean isPowerOfTwo1(int n) {
        return (n > 0 && ((n & (n - 1)) == 0));
    }


    // Day 9

    /**
     * Given a string s and a string t, check if s is subsequence of t.
     * A subsequence of a string is a new string which is formed from the original string by deleting some
     * (can be none) of the characters without disturbing the relative positions of the remaining characters.4
     * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
     */
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length())
            return false;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar, prev);
            if (prev == -1)
                return false;
            prev++;
        }
        return true;

    }
    // Day 10

    /**
     * Given a sorted array and a target value, return the index if the target is found. If not,
     * return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     */


    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return target > nums[index] ? nums.length : index;

    }

    // Day 11

    /**
     * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * <p>
     * Note: You are not suppose to use the library's sort function for this problem.
     */

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

    /**
     * Design a data structure that supports all following operations in average O(1) time.
     * <p>
     * insert(val): Inserts an item val to the set if not already present.
     * remove(val): Removes an item val from the set if present.
     * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
     */
    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int index = map.remove(val);
            int lastItem = list.remove(list.size() - 1);
            if (val != lastItem) {
                list.set(index, lastItem);
                map.put(lastItem, index);
            }
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }


    // Day 13

    /**
     * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
     * of elements in this subset satisfies:
     * Si % Sj = 0 or Sj % Si = 0.
     * If there are multiple solutions, return any subset is fin'e.
     */


    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<Integer>();
        Arrays.sort(nums);
        int maxIndex = 0, maxLength = 1;
        //used to remember the parent index of current index, parent index will be updated for each loop
        int[] index = new int[nums.length];
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // if it is can be divided
                if (nums[j] % nums[i] == 0) {
                    //compare the previous one and the current one to check the longest path
                    if (result[i] >= result[j]) {
                        result[j] = result[i] + 1;
                        index[j] = i;
                    }
                    // update max length and max index
                    if (result[j] > maxLength) {
                        maxLength = result[j];
                        maxIndex = j;
                    }
                } else {
                    // it is not in result array, set it 1
                    if (result[j] == 0) {
                        index[j] = j;
                        result[j] = 1;
                    }
                }
            }
        }
        //return
        LinkedList<Integer> list = new LinkedList<>();
        while (maxIndex != index[maxIndex]) {
            list.addFirst(nums[maxIndex]);
            maxIndex = index[maxIndex];
        }
        list.addFirst(nums[maxIndex]);
        return list;

    }


    // Day 14

    /**
     * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a
     * price w.
     * Now given all the cities and flights, together with starting city src and the destination
     * dst, your task is to find the cheapest price from src to dst with up to k stops.
     * If there is no such route, output -1.
     */

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] tempDist = Arrays.copyOf(dist, dist.length);
            for (int[] edge : flights) {
                int u = edge[0];
                if (dist[u] == Integer.MAX_VALUE)
                    continue;
                int v = edge[1];
                int w = edge[2];
                tempDist[v] = Math.min(tempDist[v], dist[u] + w);
            }
            dist = tempDist;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

}
