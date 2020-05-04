package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

import javax.swing.*;


public class Week_1_LeetCodeContest_May_30Days {

    public static void main(String[] args) {

        //day 2
        //System.out.println(numJewelsInStones("aA","aAAbbbb"));

        //day 3
        //System.out.println(canConstruct("a", "b"));

        //day 4
        System.out.println(findComplement(10));

    }
    // Day1
    /**
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
     * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
     *Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
     * You should minimize the number of calls to the API.
     * */

    ///////// 1st solution is correct but  Time Limit Exceeded
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      /*  public class Solution extends VersionControl {
            public int firstBadVersion(int n) {
                int min = Integer.MAX_VALUE;
                for(int i =1 ;i <= n ;i++){
                    if(isBadVersion(i))
                        min =Math.min(min,i);
                }
                return min;
            }
        }
    */


      /////////2nd solution by binary search algorithm it takes o(log n)

//    public int firstBadVersion(int n) {
//        int left = 1;
//        int right = n;
//        while(left < right){
//            int mid = left + (right - left) / 2;
//            if(isBadVersion(mid)){  // from API , That's already found in questions so i can't implement it here
//                right= mid ;
//            }else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }





    // Day2
    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character
     * in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
     * so "a" is considered a different type of stone from "A".
     * */

    public static int numJewelsInStones(String J, String S) {

        /*
                int count = 0;

                for (int i = 0; i <J.length() ; i++) {
                    for (int j = 0; j < S.length() ; j++) {
                        if(J.charAt(i) == S.charAt(j))
                            count++;
                    }
                }

                return count;
        */


        // optimize 1st solution
        int count =0;
        for(char c : S.toCharArray()){
            if(J.indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }


    // Day3

    /**
     * Given an arbitrary ransom note string and another string containing letters from all the magazines,
     * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise,
     * it will return false.
     * Each letter in the magazine string can only be used once in your ransom note.*/


    public static boolean canConstruct(String ransomNote, String magazine) {
        // pending solution
    /*    if( (ransomNote.length() == 0 && magazine.length() == 0) || (ransomNote.length() == 0 && magazine.length() > 0))
            return true;
        if((ransomNote.length() > 0 && magazine.length() == 0))
            return false;

        int count = 0;
        for (int i = 0; i <ransomNote.length() ; i++) {
            for (char j: magazine.toCharArray()) {
                if(ransomNote.charAt(i) == j){
                    count++;
                }else if(count == ransomNote.length()){
                    return true;
                }
                else {
                    count = 0;
                }
            }
        }

        return false;*/

     // using string builder O(n)
        StringBuilder stringBuilder = new StringBuilder().append(magazine);
        int length = ransomNote.length();
        int count = 0;
        for(int i = 0 ; i < length ; i++){
            int index = stringBuilder.indexOf(ransomNote.charAt(i)+"");
            if(index != -1){
                stringBuilder.delete(index, index+1);
                count++;
            }
        }
        if(count == length){
            return true;
        }
        return false;
    }

    // Day4

    /**
     *Given a positive integer, output its complement number. The complement strategy is to flip the bits of
     * its binary representation.*/

    public static int findComplement(int num) {


        // time limited exceeded
/*        String numToBinary = Integer.toBinaryString(num);
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i <numToBinary.length() ; i++) {
            if(numToBinary.charAt(i) == '1')
                temp.append('0');
            else
                temp.append('1');
        }
        int binaryNumber   = Integer.parseInt(String.valueOf(temp));
        int result =0 ;
        int power = 0;
        while (true){
            if(binaryNumber  == 0 )
                break;
            else {
                int test = binaryNumber %10;
                result += test * Math.pow(2,power);
                binaryNumber/=10;
                power++;
            }
        }
        return result;*/

        if (num == 0 )
            return 1;
        if ((num & (num+1)) == 0)
            return 0;

        int log2 = 31 - Integer.numberOfLeadingZeros(num); // 32 -(leading zeros) == > 31 - (32 - 4) = 3
        System.out.println("log2 = " + log2);
        long x = (long) (Math.pow(2, log2 + 1) - 1L); // 16 -  1 = 15
        System.out.println("x = " + x);

        return (int) ( x - num );
    }
}
