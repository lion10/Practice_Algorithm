package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

public class Week_1_LeetCodeContest_May_30Days {

    public static void main(String[] args) {



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





}
