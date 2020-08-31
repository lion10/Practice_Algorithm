package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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




    // Day 30: Largest Component Size by Common Factor
    /** Given a non-empty array of unique positive integers A, consider the following graph:
     There are A.length nodes, labelled A[0] to A[A.length - 1];
     There is an edge between A[i] and A[j] if and only if A[i] and
     A[j] share a common factor greater than 1.
     Return the size of the largest connected component in the graph.
     */

    public int find(int x,int[] parent){
        if(parent[x]==-1)
            return x;
        else
            parent[x]=find(parent[x],parent);
        return parent[x];
    }
    public void union(int x,int y,int[] parent){
        int xp=find(x,parent);
        int yp=find(y,parent);
        if(xp!=yp)
        {
            parent[yp]=xp;
        }
        return;
    }
    public int largestComponentSize(int[] nums) {
        int[] parent=new int[100001];
        Arrays.fill(parent,-1);
        int i;
        for(i=0;i<nums.length;i++)
        {
            for(int k=2;k<=Math.sqrt(nums[i]);k++)
            {
                if(nums[i]%k==0)
                {
                    union(nums[i],k,parent);
                    union(nums[i],nums[i]/k,parent);
                }
            }
        }
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(i=0;i<nums.length;i++)
        {
            int p=find(nums[i],parent);
            count=Math.max(count,map.getOrDefault(p,0)+1);
            map.put(p,map.getOrDefault(p,0)+1);
        }
        return count;
    }
}
