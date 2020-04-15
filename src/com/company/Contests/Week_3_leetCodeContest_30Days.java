package com.company.Contests;

import java.util.Arrays;

public class Week_3_leetCodeContest_30Days {

    public static void main(String[] args) {

        int[] temp = productExceptSelf(new int[]{1,2,3,4});
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]+ " ");
        }


    }




    /**  14th day : Given an array nums of n integers where n > 1,
     *  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     **/

    // it takes o(n^2) and extra space o(n)
/*     public static int[] productExceptSelf(int[] nums) {
         int[] temp = new int[nums.length];
         Arrays.fill(temp, 1);
         int j = 0;
         while (j < nums.length){
             for (int i = 0; i < nums.length ; i++) {
                 if(i == j){
                     continue;
                 }else {
                     temp[j] *= nums[i];
                 }
             }
             j++;
         }

         return temp;
     }*/

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = rightProduct * ans[i];
            rightProduct *= nums[i];
        }
        return ans;
    }

}
