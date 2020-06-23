package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.HashMap;
import java.util.Map;

public class Week4 {

    public static void main(String[] args) {

    }

    // Day 22 Single Number II

    /** Given a non-empty array of integers, every element appears three times except for one,
     which appears exactly once. Find that single one.
     */
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> numMap = new HashMap<>();

        for (int i=0; i < nums.length; i++)
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);


        for (Map.Entry<Integer,Integer> num : numMap.entrySet())
            if (num.getValue() != 3)
                return num.getKey();

        return 0;
    }

}
