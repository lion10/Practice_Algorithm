package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

import java.util.*;

public class Week3 {
    // Day 15 Reverse Words in a String
    /** Given an input string, reverse the string word by word.
     */

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // Day 16 Pow(x, n)
    /** Implement pow(x, n), which calculates x raised to the power n (xn).*/

    public double myPow(double x, int n) {
        if(n == 1)
            return x;
        if(n == -1)
            return 1 / x;
        if(n == 0)
            return 1.0;

        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }
    // Day 17 Top K Frequent Elements
    /** Given a non-empty array of integers, return the k most frequent elements. */

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] result = new int[k];
        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b)->freq.get(b) - freq.get(a));
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for(int key: freq.keySet()) {
            pq.add(key);
        }
        while(k>0) {
            result[k-1] = pq.poll();
            k --;
        }
        return result;
    }


    // Day 18 Course Schedule II

    /** There are a total of n courses you have to take, labeled from 0 to n-1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

     There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.*/

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //  Pre-reqruisite ==> to Adjacent Course
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        int [] Indegree = new int[numCourses];
        // Initialize graph
        for( int i=0; i < numCourses ; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for( int i=0 ; i < prerequisites.length ; i++) {
            int [] preq = prerequisites[i];
            //  Pre-reqruisite to List of adjacent Course
            graph.get(preq[1]).add(preq[0]);
            Indegree[preq[0]]++; // Increase Indegree as it has pre-reqrisite
        }
        // BFS - Tropological sorting algorithm
        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i=0; i < numCourses ; i++) {
            if(Indegree[i] == 0 )
            {
                queue.offer(i);
            }
        }
        int index=0;
        int []out = new int[numCourses];
        Arrays.fill(out,-1);
        while(!queue.isEmpty()) {
            int  curr = queue.remove();
            out[index++] = curr;
            // For all Adjacent course to it , reduce Indegree as it is removed from Graph
            for( int p : graph.get(curr))
            {
                Indegree[p]--;
                if(Indegree[p] == 0 )
                {
                    queue.offer(p);
                }
            }
        }
        // If no. of course reachable not equal to numCourses ,
        // it is impossible to finish all courses, return an empty array.
        if( index < numCourses ) {
            return ( new int[0]);
        }
        return(out);
    }


    // Day 19 Add Binary

    /** Given two binary strings, return their sum (also a binary string).
     The input strings are both non-empty and contains only characters 1 or 0.
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while(i >= 0 || j >= 0){
            int sum = 0;
            if(i >= 0 && a.charAt(i) == '1')
                sum++;
            if(j >= 0 && b.charAt(j) == '1')
                sum++;
            sum += carry;
            if(sum >= 2)
                carry = 1;
            else
                carry = 0;

            sb.insert(0,(char) ((sum % 2) + '0'));
            i--;
            j--;

        }
        if(carry == 1)
            sb.insert(0, '1');

        return sb.toString();
    }
    // Day 20 Remove Linked List Elements
    /** Remove all elements from a linked list of integers that have value val.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null)
            return null;
        ListNode pre = head, cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
