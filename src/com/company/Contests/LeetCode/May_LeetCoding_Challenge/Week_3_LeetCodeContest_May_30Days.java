package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

import java.util.Arrays;

public class Week_3_LeetCodeContest_May_30Days {

    public static void main(String[] args) {
        // Day 15
        System.out.println(maxSubarraySumCircular(new int[]{-2,-3,-1}));

    }



    // Day 15
    /** Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

     Here, a circular array means the end of the array connects to the beginning of the array.
     (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

     Also, a subarray may only include each element of the fixed buffer A at most once.
     (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
     */
    public static int maxSubarraySumCircular(int[] A) {
        int maxSum = Arrays.stream(A).max().getAsInt();
        if (maxSum < 0)
            return maxSum;

        int maxKadane = KadaneAlgorithm(A);
        int maxWrap = 0;
        for (int i = 0; i < A.length; i++) {
            maxWrap += A[i];
            A[i] = -A[i];
        }
        maxWrap = maxWrap + KadaneAlgorithm(A);

        return maxWrap > maxKadane ? maxWrap : maxKadane;
    }

    private static int KadaneAlgorithm(int[] A) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < A.length ; i++) {

            maxEndingHere = maxEndingHere + A[i];

            if (maxEndingHere < 0 )
                maxEndingHere = 0;

            if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }

        return maxSoFar;
    }


}
