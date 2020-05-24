package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

import java.util.*;
import java.util.Map.Entry;

public class Week_4_LeetCodeContest_May_30Days {

    public static void main(String[] args) {
        //Day 22
        System.out.println(frequencySort("tree"));
    }


    //Day 22
    /** Given a string, sort it in decreasing order based on the frequency of characters*/

    public static String frequencySort(String s) {
        HashMap<Character,Integer> hashMap =  new HashMap<>();
        for (char ch: s.toCharArray()) {
            if(!hashMap.containsKey(ch)){
                hashMap.put(ch,1);
            }else {
                hashMap.put(ch,hashMap.get(ch)+1);
            }
        }

        Set<Entry<Character, Integer>> set = hashMap.entrySet();
        List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(
                set);
        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuffer temp = new StringBuffer();
        for (Entry<Character, Integer> entry : list) {
            int val = entry.getValue();
            while (val!=0){
                temp.append(entry.getKey());
                val--;
            }
        }
        return temp.toString();
    }

    // Day 23
    /** Given two lists of closed intervals, each list of intervals is pairwise disjoint
     *  and in sorted order.
        Return the intersection of these two interval lists.*/

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        ArrayList<int[]> result = new ArrayList<>();

        while(i < A.length && j < B.length){

            int l1 = Math.max(A[i][0], B[j][0]);
            int l2 = Math.min(A[i][1], B[j][1]);

            if(A[i][1] < B[j][0] || B[j][1] < A[i][0]){
                l1 = 0;
                l2 = 0;
            }

            if(l1 != 0 || l2 != 0)
                result.add(new int[]{l1, l2});

            if(A[i][1] < B[j][1])
                i++;

            else
                j++;

        }
        return result.toArray(new int[result.size()][]);
    }


}
