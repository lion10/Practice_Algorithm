package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Week3 {



    // Day 15: Non-overlapping Intervals
    /** Given a collection of intervals, find the minimum number
     *  of intervals you need to remove to make the rest of the intervals non-overlapping.
     */

    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a,int [] b){
            if(a[0] != b[0])
                return Integer.compare(a[0],b[0]);
            else
                return Integer.compare(a[1],b[1]);
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,  new IntervalComparator());

    /*    for (int i = 0; i <intervals.length ; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                System.out.print(intervals[i] + " ");
            }
            System.out.println();
        }*/

        int ans = 0;
        if(intervals.length == 0)
            return ans;
        int idx = 0;
        for(int i = 1; i < intervals.length; i++){
            int [] taken = intervals[idx];
            int [] current = intervals[i];
            if(current[0] >= taken[0] && current[0] < taken[1]){
                if(current[1] < taken[1]){
                    idx = i;
                }
                ans++;
            }
            else{
                idx = i;
            }
        }
        return ans;
    }


    // Day 16: Best Time to Buy and Sell Stock III
    /** Say you have an array for which the ith element is the price of a given stock on day i.
     Design an algorithm to find the maximum profit. You may complete at most two transactions.
     Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).*/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) {
            return 0;
        }

        int fb = Integer.MIN_VALUE;
        int sb = Integer.MIN_VALUE;
        int fs = 0;
        int ss = 0;

        for(int i=0;i<n;i++) {
            fb = Math.max(fb,-prices[i]);
            fs = Math.max(fs, fb + prices[i]);
            sb = Math.max(sb, fs - prices[i]);
            ss = Math.max(ss, sb + prices[i]);
        }
        return ss;
    }



    //  Day 17: Distribute Candies to People
    /** We distribute some number of candies, to a row of n = num_people people in the following way:
     We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
     Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
     This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
     Return an array (of length num_people and sum candies) that represents the final distribution of candies.
     */


    public int[] distributeCandies(int candies, int num_people) {

        // Time Limit Exceeded
     /*  int count = 1;
       boolean test = true;
       int[] result = new int[num_people];
       int j = 0;
       int total = 0;
       while(test){
           result[j] = count;
           total += result[j];
           if (total == candies){
               test = false;
           }
           j++;
           count++;
           if (result.length == num_people){
               j = 0;
           }
       }
       return result;*/


        int[] result = new int[num_people];
        if(candies == 0) {
            return result;
        }
        int n = 1;


        while(candies - n > 0) {
            result[(n - 1) % num_people] += n;
            candies -= n;
            n++;
        }

        if(candies > 0) {
            result[(n- 1) % num_people] += candies;
        }
        return result;
    }



    // Day 18: Numbers With Same Consecutive Differences
    /**
     * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
     *
     * Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
     *
     * You may return the answer in any order.*/

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> result = new ArrayList<>();
        for (int num = 1; num < 10; ++num)
            dfs(N - 1, num, K, result);

        // convert the ArrayList to int[]
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int N, int num, int K, List<Integer> results) {
        if (N == 0) {
            results.add(num);
            return;
        }

//        if (num % 10 + K < 10)
//            dfs(N - 1, num * 10 + num % 10 + K, K, results);
//
//        if (K > 0 && num % 10 - K >= 0)
//            dfs(N - 1, num * 10 + num % 10 - K, K, results);

        List<Integer> nextDigits = new ArrayList<>();

        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + K);
        if (K != 0)
            nextDigits.add(tailDigit - K);
        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                this.dfs(N - 1, newNum, K, results);
            }
        }
    }




}
