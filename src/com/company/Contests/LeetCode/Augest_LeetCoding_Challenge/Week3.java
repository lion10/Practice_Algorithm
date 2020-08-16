package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.Arrays;
import java.util.Comparator;

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
}
