package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

import java.util.*;

public class Week5 {

    // Day 29:  Best Time to Buy and Sell Stock with Cooldown
    /** Say you have an array for which the ith element is the price of a given stock on day i.
     Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie,
     buy one and sell one share of the stock multiple times) with the following restrictions:
     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)*/

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;

        int b0 = -prices[0];
        int b1 = b0;
        int s0 = 0;
        int s1 = 0;
        int s2 = 0;
        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }


    // Day 30: Word Break II
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
     * Note:
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.*/

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        Map<String,List<String>> memo = new HashMap<>();

        return helper(dict, s , memo);
    }


    private List<String> helper(Set<String> dict , String s , Map<String,List<String>> memo){

        if(memo.containsKey(s))
            return memo.get(s);

        List<String> ans = new ArrayList<>();

        if(s == null || s.isEmpty()){
            return ans;
        }

        int N = s.length();

        for(String word : dict){

            if(!s.startsWith(word)){
                continue;
            }
            int len = word.length();
            if(N == len){
                ans.add(word);
            }else{
                List<String> res = helper(dict , s.substring(len),memo );
                for(String str : res){
                    ans.add( word + " " + str);
                }
            }
        }
        memo.put(s,ans);
        return ans;
    }


    // Day 31: Climbing Stairs
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     **/
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int first = 1;
        int secound = 2;
        for(int i = 3 ; i <= n; i++){
            int third = first+ secound;
            first = secound;
            secound = third;
        }

        return secound;
    }

}
