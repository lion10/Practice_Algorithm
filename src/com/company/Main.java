package com.company;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {
    public static int[] rwr = {4,5,1,4,2};

    public static void main(String[] args) {

        int[] test = customerCare(rwr);
        for (int i = 0; i <test.length ; i++) {
            System.out.print(test[i]);
        }
    }


    public static int[] customerCare(int[] arr){
        int[] indices = new int[arr.length];
        indices[0] = 1;
        for(int i = 1 ; i < arr.length; i++){
            int j = i;
            for(; j >= 1 && arr[j] < arr[j-1]; j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                indices[j] = indices[j-1];
                arr[j-1] = temp;
            }
            indices[j] = i+1;
        }
        return indices;
    }

    // problem #1
    public static int sumElements1D(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
                sum+= arr[i];
        }
        return sum;
    }

    // problem #2
    public static int sumElements2D(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
                sum+= arr[i][i];
        }
        return sum;
    }



    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        int[] temp = new int[21];
        for (int i = 1; i <=20 ; i++) {
            temp[i] = i*5;
        }

        for (Integer m: grades) {
            int j ;
            for (j = 0; j < temp.length ; j++) {
                if(temp[j] >= m)
                    break;
            }
            if (m <= 37)
                result.add(m);
            else if(Math.abs(m - temp[j]) < 3)
                result.add(temp[j]);
            else
                result.add(m);
            j = 0;
        }
        return result;

    }


    static int sockMerchant(int n, int[] ar) {

        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (!colors.contains(ar[i])) {
                colors.add(ar[i]);
            } else {
                pairs++;
                colors.remove(ar[i]);
            }
        }
        return pairs;

    }


} 
  