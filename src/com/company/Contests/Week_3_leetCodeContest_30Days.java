package com.company.Contests;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

public class Week_3_leetCodeContest_30Days {

    public static void main(String[] args) {

        //14th day
      /*  int[] temp = productExceptSelf(new int[]{1,2,3,4});
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]+ " ");
        }
        */

        //15th day
        System.out.println(checkValidString("(*))"));;


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

    /**
     * 15th day :Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
     * An empty string is also valid.
     **/


    // not correct answer there some cases not accept it lol -_-
  /*  public static boolean checkValidString(String s) {
        Stack<Character> tracer = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            if ( s.charAt(i) == '(' ){
                tracer.push(s.charAt(i));
                System.out.printf("i = %d  tracer = %s \n",i,tracer.toString());
            } else{
                if(tracer.isEmpty()){
                    System.out.println("hack");
                    return false;
                }
                char lastValue = tracer.peek();
                if( (s.charAt(i)== ')' && lastValue == '(') ||  (s.charAt(i)== '*' && lastValue == '(') || (s.charAt(i)== '*' && lastValue == ')')) {
                    tracer.pop();
                   System.out.printf("i = %d  tracer = %s \n",i,tracer.toString());
                } else {
                    break;
                }
            }
        }
        return tracer.size() == 0 ;

    }*/


  // == >   (*)) solve it by Greedy  approach

    public static boolean checkValidString(String s) {
        int leftPer = 0, rightPer = 0;
        for (char ch: s.toCharArray()) {
            leftPer += (ch == '(' ? 1 : -1);
            rightPer += (ch != ')' ? 1 : -1);
            if (rightPer < 0) break;
            leftPer = Math.max(leftPer, 0);
        }
        return leftPer == 0;
    }
}
