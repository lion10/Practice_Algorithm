package com.company.Contests;

public class leetCodeContest_30Days {


    public static void main(String[] args) {
       //1st day
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));

    }


   /* 1st day : Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
    public static int singleNumber(int[] nums) {
        int temp = 0 ;
        for (int i = 0; i <nums.length ; i++) {
            temp ^= nums[i];
        }
        return  temp;
    }
}
