package com.company.Company_Challenge;

import java.util.ArrayList;
import java.util.Arrays;

public class MIU {
    public static void main(String[] args) {

        //q1
        System.out.println(q1(new int[]{10}));

        //q2
        System.out.println(q2(new int[]{3, 3, 4, 4}));

        //q3
        System.out.println(q3(new char[]{'a', 'b', 'c'}, 0, 1)[0]);
    }

    public static int q1(int[] arr){
        int count = 0;
        if (arr.length % 2 == 0)
            return 0;
        else {
            int mid = arr[arr.length / 2];
            for (int i = 0; i < arr.length; i++) {
                if(i == arr.length / 2 )
                    continue;
                else {
                    if(arr[i] <= mid){
                       count++;
                    }
                }
            }

        }
        return count > 0 ? 0 : 1 ;
    }

    public static int q2(int[] a){
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < a.length; i++) {
            if(i%2 == 0 ){
                sumEven += a[i];
            }else{
                sumOdd += a[i];
            }
        }
        return sumOdd - sumEven;
    }

    public static char[] q3(char[] a, int start, int len){

        if (a.length < 0 ||start+len -1 >= a.length || start < 0){
            return null;
        }

        char[] arr = new char[len];

           for (int i = start , j = 0 ; j < len ; i++, j++) {
                arr[j] = a[i];
           }

        return arr;
    }

}
