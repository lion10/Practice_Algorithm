package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.List;

public class Week5 {

    // Day 29: Pancake Sorting

    /**
     *  Given an array of integers A, We need to sort the array performing a series of pancake flips.
     In one pancake flip we do the following steps:
     Choose an integer k where 0 <= k < A.length.
     Reverse the sub-array A[0...k].
     For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2, we reverse
     the sub-array [3,2,1], so A = [1,2,3,4] after the pancake flip at k = 2.
     Return an array of the k-values of the pancake flips that should be performed in order to sort A. Any valid
     answer that sorts the array within 10 * A.length flips will be judged as correct.*/

    void rev(int[] a, int i, int j){
        while(i<j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++; j--;
        }
    }

    int find(int[] a, int n){
        for(int i=0; i<a.length; i++)
            if(a[i] == n)
                return i;
        return 0;
    }

    public List<Integer> pancakeSort(int[] a) {

        List<Integer> result = new ArrayList<>();
        // each round, flip the n to the 0 index then flip to the n-1index.
        for(int n = a.length; n >= 1; n--){
            int idx = find(a, n);
            if(idx+1 == n) continue; // skip when the n already in n-1 index
            result.add(idx + 1);
            rev(a, 0, idx);
            result.add(n);
            rev(a, 0, n-1);
        }
        return result;
    }
}
