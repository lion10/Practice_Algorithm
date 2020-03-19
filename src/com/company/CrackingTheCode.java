package com.company;

import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.lang.Integer.max;

public class CrackingTheCode {
    private static int temp;



    public static void main(String[] args) {

    /*    String[][] pairs = {{"abb","bba"},{"moh","hom"},{"asda","dsa"}};
        for (String[] pair: pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean permutation = checkPermutation(word1,word2);
            System.out.println(permutation);
        }*/
/*        String a =     "momoo";
        System.out.println(palindromePermutation(a.toLowerCase()));*/

        System.out.println(oneAway("pa","pale"));
    }

    public static  boolean oneAway(String str1 ,String str2 ){
        if(Math.abs(str1.length() - str2.length()) > 1){
            return false;
        }
        String s1 = str1.length() < str2.length() ? str1 : str2; // smallest
        String s2 = str1.length() < str2.length() ? str2 : str1; // biggest
        int index1 = 0, index2 = 0;
        boolean isMoreThanOneEdit = false;

        while (index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(isMoreThanOneEdit)
                    return false;
                isMoreThanOneEdit = true;
                if(s1.length() == s2.length()) // if replace
                    index1++;
            }else {
                index1++; // if match
            }
            index2++; // always longer string index
        }
        return true;
    }



    public static int getNumberChar(char temp){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(temp);
        if(val >= a && val <= z){
         //   System.out.println("val = " + (val - a));
            return val - a;
        }
        return -1;
    }


    public static int[] frequencyForEachCharInString(String str){
        int[] frequencyChar = new int[getNumberChar('z')-getNumberChar('a') +1 ];
        for (char c: str.toCharArray()) {
            if(getNumberChar(c) != -1){
              //  System.out.println("c = " + getNumberChar(c));
                frequencyChar[getNumberChar(c)]++;
            }
        }
        return frequencyChar;
    }
    public static boolean checkIfMaxOneOdd(int[] arr){
        boolean isMaxOddOneOnly = false;
        for (int index: arr) {
            if(index % 2 == 1){
                if(isMaxOddOneOnly){
                    return false;
                } // that's mean i found more than one's odd in array ...
                isMaxOddOneOnly =true;
            }
        }
        return true;
    }


    public static boolean palindromePermutation(String str){
        int[] arr  = frequencyForEachCharInString(str);
        return checkIfMaxOneOdd(arr);

    }





    public static String replaceWhiteSpaceWith(String a){
        char[] temp = a.toCharArray();
        int tempLength= temp.length;
        int lengthOfTemp2 =tempLength + countSpaces(temp);
        char[] temp2 = new char[lengthOfTemp2];
        int j = 0;
        int i = 0;
        while( j < tempLength)  {
            if(temp[j] == ' '){
                temp2[i] ='%';
                temp2[i+1] ='2';
                temp2[i+2] ='0';
                i=i+3;
       //         System.out.printf("i : %d",i);
            }else {
                temp2[i] = temp[j];
                i++;
            }
            j++;
        }
        return new String(temp2);
    }

    public static int countSpaces(char[] tempChar){
        int sumOfSpaces = 1;
        for (int i = 0; i < tempChar.length; i++) {
            if(tempChar[i] ==' ')
                sumOfSpaces++ ;
        }
        return  sumOfSpaces*2;
    }


    public static boolean checkPermutation(String a,String b){
        return sortString(a).equals(sortString(b));
    }
    private static String sortString(String test) {
        char[] tempChar = test.toCharArray();
        Arrays.sort(tempChar);
        return new String(tempChar);
    }


    public static ArrayList<Pair<Integer, Integer>> pairToEqualExactNumber(int[] arr , int arrLength , int k ){
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arrLength ; i++) {
            temp = arr[i] + k;
            int testIfFound = indexFromBinarySearch(arr, temp);
            if (testIfFound != -1){
                arrayList.add(new Pair<>(arr[i],arr[testIfFound] ));
           }
        }

        return arrayList ;
    }


    public static int indexFromBinarySearch(int[] arr, int valueForTarget){
        int start =0 ;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start+end)/2 ;
            if(arr[mid] == valueForTarget){
                return mid;
            }
            else if(valueForTarget > arr[mid])
                start =mid+1;
            else
                end = mid-1;

        }
        return -1 ;
    }



    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String,Integer> hashMap = new HashMap<>();
        for (String a: magazine) {
            if(!hashMap.containsKey(a))
                hashMap.put(a,1);
            else
                hashMap.put(a,hashMap.get(a)+1);
        }

        for (String a: note) {
            if(hashMap.containsKey(a)) {
                hashMap.put(a,hashMap.get(a)-1);
                if(hashMap.get(a) <0){
                    System.out.println("NO");
                    return;
                }
            }
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static boolean isAllCharsUnique(String s){
        int i = 0 ;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char a: s.toCharArray()) {
            if(!hashMap.containsKey(a))
                hashMap.put(a,1);
            else
                return false;
        }
        return true ;
    }

    public static boolean isUniqueChar(String s){
        int checker = 0;
        for (int i = 0; i <s.length() ; i++) {
            int val = s.charAt(i) - 'a'; // val is 32 bits
            if((checker & (1 << val)) > 0) return false ;
                checker |=(1 << val);
        }
        return  true ;
    }








}

