package com.company.Contests.LeetCode;

public class Week_4_leetCodeContest_30Days {

    public static void main(String[] args) {
        // 21th day:
        // System.out.println(subarraySum(new int[]{1,2,2},2));

        // 22th day:
        System.out.println(rangeBitwiseAnd(5,7));

    }


    /** 21th day:
     Given an array of integers and an integer k, you need to find the total number of
     continuous subarrays whose sum equals to k.
     */


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int j = 0;
        while (j < nums.length){
            int total = 0;
            for (int i = j; i < nums.length ; i++) {
                total += nums[i];
                if(total == k){
                    count++;
                    // break; //  if i put here break then this case not get the result exactly [0,0,0,0,0] and k = 0
                }
            }
            j++;
        }
        return count;
    }

    /** 22th day:
     Given an array of integers and an integer k, you need to find the total number of
     continuous subarrays whose sum equals to k.
     */

    public static int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        while(n > m){
            n = n & n-1;
        //    System.out.println(n);
        }
        return  n;
    }


}
