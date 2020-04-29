package com.company.Contests.HackerRank;

import java.util.ArrayList;

public class TestOnHackerrank {



    public static void main(String[] args) {
       /* 5 3
        4 2 6 1 10*/

       System.out.println(workbook(5,3,new int[]{4 ,2 ,6 ,1 ,10}));



    }

    // 1st question


    static int[] width;
    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int[][] cases) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < cases.length; i++) {
            result.add(findMinIndexes(width,cases[i][0],cases[i][1]));
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private static int findMinIndexes( int[] list, int st, int ed) {

        int min = Integer.MAX_VALUE;

        for (int i = st; i <= ed; i++) {
            if(list[i] < min){
                min = list[i];
            }
        }
        return min;
    }



    //2nd question

    static int workbook(int n, int k, int[] arr) {
        int page = 0 ;
        int p = 0;
        int count = 0;

        for (int i = 0; i <arr.length; i++) {
           int min = arr[i];
           p =1;
           page++;
           while (p <= min){
               if(p == page){
                   count++;
               }
               if(p % k == 0 && p < min)
                   page++;

               p++;
           }
        }
        return count;
    }



    //3rd question
    //4th question
    //5th question



}
