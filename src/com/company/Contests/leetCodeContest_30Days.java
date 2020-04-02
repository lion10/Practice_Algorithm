package com.company.Contests;

public class leetCodeContest_30Days {


    public static void main(String[] args) {
       //1st day
        //System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        // 2nd day
        System.out.println(isHappy(8));
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



}
