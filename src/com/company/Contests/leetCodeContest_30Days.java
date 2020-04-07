package com.company.Contests;

import java.util.*;

public class leetCodeContest_30Days {


    public static void main(String[] args) {
       //1st day
        //System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        // 2nd day
       // System.out.println(isHappy(8));
        // 3rd day
        //System.out.println(maxSubArray(new int[]{-2}));
        // 4th day
        /*int[] a = moveZeroes(new int[]{1,5,0,0,1,2,5,9});
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }*/
        // 5th day
      /*  int[] temp =  {7,1,5,3,6,4};
        System.out.println(maxProfit(temp));;*/

      // 6th day
      /*  String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs).toString());*/

      // 7th day
        System.out.println(countElements(new int[]{1,3,2,3,5,0}));


    }

    /////////////////////////////////////////////////////////////// 1st  day ///////////////////////////////////////////////////

   /* 1st day : Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
    public static int singleNumber(int[] nums) {
        int temp = 0 ;
        for (int i = 0; i <nums.length ; i++) {
            temp ^= nums[i];
        }
        return  temp;
    }
    /////////////////////////////////////////////////////////////// 2nd  day ///////////////////////////////////////////////////

       /* 2st day : Write an algorithm to determine if a number is "happy".

        A happy number is a number defined by the following process: Starting with any positive integer,
         replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
         (where it will stay), or it loops endlessly in a cycle which does not include 1.
         Those numbers for which this process ends in 1 are happy numbers.*/


      /*


       public static boolean isHappy(int n) {
            StringBuilder tempValue = new StringBuilder().append(n);
           //System.out.println("tempValue = " + tempValue);
            int reslut = calculateResult(tempValue);
            //System.out.println("reslut = " + reslut);
            if(reslut == 1)
                return true ;
           if(reslut == Integer.MAX_VALUE){
               return false ;
           }
            while (reslut != 1 ){
                boolean te = isHappy(reslut);
                if (te){
                    return true;
                }
            }

           return false;
       }
       public static int calculateResult(StringBuilder num){
           int total = 0 ;
           for (int i = 0; i < num.length() ; i++) {
                total += pawOfTwo(Character.getNumericValue(num.charAt(i)));
           }
           return total;

       }

       public static int pawOfTwo(int sum){
           return (int) Math.pow(sum , 2);
       }*/

    public static int numSquareSum(int n) {
        int squareSum = 0;
        while (n!= 0) {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }

    //  method return true if n is Happy number
    public static boolean isHappy(int n) {
        int slow, fast;
        //  initialize slow and fast by n
        slow = fast = n;
        do {
            //  move slow number by one iteration
            slow = numSquareSum(slow);
            //  move fast number by two iteration
            fast = numSquareSum(numSquareSum(fast));
        } while (slow != fast);
        //  if both number meet at 1, then return true
        return (slow == 1);
    }

    /////////////////////////////////////////////////////////////// 3rd  day ///////////////////////////////////////////////////

    // Given an integer array nums, find the contiguous subarray (containing at least one number)
    // which has the largest sum and return its sum.


    public static int maxSubArray(int[] nums) {
        int maxUntilHere = nums[0];
        int currentMax = nums[0];
        if(nums.length == 1 ){
            return  nums[0];
        }

        for (int i = 1; i <nums.length ; i++) {
            currentMax = Math.max(nums[i] , currentMax + nums[i]);
            maxUntilHere = Math.max(currentMax , maxUntilHere);
        }
        return maxUntilHere ;
    }

    /////////////////////////////////////////////////////////////// 4th  day ///////////////////////////////////////////////////


    public static int[] moveZeroes(int[] nums) {
        int pointer = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 )
                nums[pointer++] = nums[i];
        }
        while (pointer < nums.length)
            nums[pointer++] = 0;

        return nums;
    }

    /////////////////////////////////////////////////////////////// 5th  day ///////////////////////////////////////////////////



    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

    Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
    */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0 ;
        int countPriceMoreThanDayBefore=0;
        for (int i = 0; i <prices.length-1 ; i++) {
            if(prices[i] <= prices[i+1]){
                 maxProfit += (prices[i+1]-prices[i]);
            } else {
                countPriceMoreThanDayBefore++;
            }
        }

        if(countPriceMoreThanDayBefore == prices.length - 1 )
            return  0;
        return maxProfit ;

    }

    /////////////////////////////////////////////////////////////// 6th  day ///////////////////////////////////////////////////


     //  Given an array of strings, group anagrams together.

    /*
    *   Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:[
                  ["ate","eat","tea"],
                  ["nat","tan"],
                  ["bat"]
                ]
    */

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> groupAnagrams = new ArrayList<>();
        HashMap<String , List<String>>  map = new HashMap<>();

        for (String str: strs) {
            char[] tempCharArray =str.toCharArray();
            Arrays.sort(tempCharArray);
            String key = new String(tempCharArray);
            if(map.containsKey(key)){
                map.get(key).add(str); // to get key which key consider it as ArrayList so we add str
        //        System.out.println(map.get(key));
            }else{
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(key,stringList);
            }
        }

        groupAnagrams.addAll(map.values()); // map.values() === > stringList ArrayList;
        return  groupAnagrams;
    }

    /////////////////////////////////////////////////////////////// 7th  day ///////////////////////////////////////////////////
    /*
    * Given an integer array arr, count element x such that x + 1 is also in arr.
    * If there're duplicates in arr, count them seperately.
        * */

        /*    public static int countElements(int[] arr) {
        int totalOfDuplicatesNumber = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (binarySearch(arr,arr[i]+1) != -1){
                totalOfDuplicatesNumber++;
            }
        }
        return totalOfDuplicatesNumber;
        }*/

       /* public static int binarySearch(int arr[], int x) {
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (arr[m] == x)
                    return m;
                if (arr[m] < x)
                    l = m + 1;
                else
                    r = m - 1;
            }
            return -1;
        }*/


   // by hash set
    public static int countElements(int[] arr) {
        int totalOfDuplicatesNumber = 0;
        Set<Integer> set= new HashSet<>();
        for (int v: arr) {
            set.add(v);
        }
        for (int i:arr) {
            if(set.contains(i+1)){
                totalOfDuplicatesNumber++;
            }
        }
        return totalOfDuplicatesNumber ;
    }



}
