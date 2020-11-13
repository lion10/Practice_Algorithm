package com.company;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        //System.out.println( isStepped( new int[]{1, 1, 1, 1, 1, 1, 1}));
      //  System.out.println(is235Array(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10},9));
        System.out.println(isDigitIncreasing(24));
        System.out.println(isDigitIncreasing(7));
        System.out.println(isDigitIncreasing(36));
        System.out.println(isDigitIncreasing(984));
        System.out.println(isDigitIncreasing(7404));
    }
    public static int isStepped(int[ ] a){
        int count = 0;
        for (int i = 0; i < a.length-1 ; i++) {
            if (a[i] <= a[i+1])
                count++;
            else
                break;
        }
        return count == a.length -1 ? 1 : 0;
    }

    public static int is235Array(int a[ ], int len){
        int numOfEleDivisibleBy2 = 0;
        int numOfEleDivisibleBy3 = 0;
        int numOfEleDivisibleBy5 = 0;
        int numOfEleNotDivisibleBy2or3or5 = 0;
        for (int i = 0; i <a.length ; i++) {
            if (a[i] % 2 == 0)
                numOfEleDivisibleBy2++;
            if (a[i] % 3 == 0)
                numOfEleDivisibleBy3++;
            if (a[i] % 5 == 0)
                numOfEleDivisibleBy5++;
            if (a[i] % 2 != 0 && a[i] % 3 != 0 && a[i] % 5 != 0)
                numOfEleNotDivisibleBy2or3or5++;
        }
        return numOfEleDivisibleBy2 + numOfEleDivisibleBy3+numOfEleDivisibleBy5 +numOfEleNotDivisibleBy2or3or5 == len ? 1: 0;
    }

    public static int isDigitIncreasing(int n){

        if (n <= 0 )
            return 0;

        if (n >= 1 && n <= 9)
            return 1;

        for (int i = 1; i <= 9; i++) {
            int result = 0;
            int nSeries = 0;

            while (result < n) {
                nSeries = (nSeries * 10) + i; // n , nn , nnn , ...
                result += nSeries;// n + nn + nnn + ...
            }

            if (result == n)
                return 1;
        }
        return 0;
    }
}
