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

}
