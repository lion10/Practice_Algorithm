package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

public class Week1 {
    public static void main(String[] args) {

    }
    // Day 1 Arranging Coins
    /** You have a total of n coins that you want to form in a staircase shape, where every k-th
     * row must have exactly k coins.
     Given n, find the total number of full staircase rows that can be formed.
     n is a non-negative integer and fits within the range of a 32-bit signed integer.*/
    public int arrangeCoins(int n) {
        int count = 0;
        for (int i = 1 ; i <=n ; i++){
            if ( n <= 0 )
                break;
            n -=i;
            count++;
        }
        return count;
    }

}
