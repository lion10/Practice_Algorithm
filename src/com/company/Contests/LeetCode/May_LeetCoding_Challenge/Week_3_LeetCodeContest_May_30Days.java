package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

import java.util.Arrays;

public class Week_3_LeetCodeContest_May_30Days {

    public static void main(String[] args) {
        // Day 15
        System.out.println(maxSubarraySumCircular(new int[]{-2,-3,-1}));

    }



    // Day 15
    /** Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

     Here, a circular array means the end of the array connects to the beginning of the array.
     (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

     Also, a subarray may only include each element of the fixed buffer A at most once.
     (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
     */
    public static int maxSubarraySumCircular(int[] A) {
        int maxSum = Arrays.stream(A).max().getAsInt();
        if (maxSum < 0)
            return maxSum;

        int maxKadane = KadaneAlgorithm(A);
        int maxWrap = 0;
        for (int i = 0; i < A.length; i++) {
            maxWrap += A[i];
            A[i] = -A[i];
        }
        maxWrap = maxWrap + KadaneAlgorithm(A);

        return maxWrap > maxKadane ? maxWrap : maxKadane;
    }

    private static int KadaneAlgorithm(int[] A) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < A.length ; i++) {

            maxEndingHere = maxEndingHere + A[i];

            if (maxEndingHere < 0 )
                maxEndingHere = 0;

            if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }

        return maxSoFar;
    }

    // Day 16
    /**Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we
     *are talking about the node number and not the value in the nodes.
     You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.*/

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode node = head;
            ListNode last = head;
            int len = 1;
            while(last.next!= null){
                last = last.next;
                len++;
            }
            for(int i = 0; i < len/2; i++){
                last.next = node.next;
                last = last.next;
                node.next = node.next.next;
                node = node.next;
                last.next = null;
            }
            return head;

        }
    }
}
