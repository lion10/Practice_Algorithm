package com.company.Contests.HackerRank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TestOnHackerrank {



    public static void main(String[] args) {
       /* 5 3
        4 2 6 1 10*/

      // System.out.println(workbook(5,3,new int[]{4 ,2 ,6 ,1 ,10}));

        //3rd question == > 20/25 cases passed
       almostSorted(new int[]{1 ,5, 4, 3, 2, 6});


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

    static void almostSorted(int[] arr) {
        int[] temp = arr.clone();
        int[] tempArr = sortTheArray(arr);
        /*printArray(temp);
        printArray(tempArr);*/
        ArrayList<Integer> countDifferentIndexes = countDifferentIndexes(temp,tempArr);
        if(countDifferentIndexes.get(0) == 2 ){
            System.out.println("yes");
            System.out.println("swap " + countDifferentIndexes.get(1)+" "+countDifferentIndexes.get(2)   );

        }else if(countDifferentIndexes.get(0) > 2 && isReverseEqualTheSorted(temp,countDifferentIndexes.get(1),countDifferentIndexes.get(2))){

            System.out.println("yes");
            System.out.println("reverse " + countDifferentIndexes.get(1)+" "+countDifferentIndexes.get(2));
        }else if(countDifferentIndexes.get(0) == 0  ){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }


    }

    private static boolean isReverseEqualTheSorted(int[] temp, int fisrt, int last) {
        int[] tempTest = temp.clone();

        Arrays.sort(temp,fisrt-1,last);
        sortTheArray(tempTest);

        // System.out.println("test " + countDifferentIndexes(tempTest,temp).get(0));
        return countDifferentIndexes(tempTest,temp).get(0) == 0? true : false ;
    }


    private static ArrayList<Integer> countDifferentIndexes(int[] arr, int[] tempArr) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int count = 0;
        int first = 0;
        int last = 0;
        boolean test = true;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] != tempArr[i] && test){
                count++;
                first = i+1;
                test= false;
            }else if(arr[i] != tempArr[i] ){
                count++;
                last =i;
            }
        }
        last++;
        indexes.add(count);
        indexes.add(first);
        indexes.add(last);
        return indexes;

    }
    private static int[] sortTheArray(int[] arr) {
        int temp[] = new int[arr.length];
        Arrays.sort(arr);
        for (int i = 0; i <temp.length ; i++) {
            temp[i]= arr[i];
        }
        return temp;
    }

    public static void printArray(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    //4th question
    //5th question
}
