package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week_3_LeetCodeContest_May_30Days {

    public static void main(String[] args) {
        // Day 15
        // System.out.println(maxSubarraySumCircular(new int[]{-2,-3,-1}));

        // Day 17
        // System.out.println(findAnagrams("cbaebabacd","abc"));

        // Day 18
        System.out.println(checkInclusion("ab","eidbaooo"));

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

    //Day 17 solved it by sliding window technique

    /**
     Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
     The order of output does not matter.
     */

    public static List<Integer> findAnagrams(String s, String p) {
        int[] letters = new int[26];
        for (int i = 0; i < p.length(); i++) {
            letters[p.charAt(i) - 'a']++;
            // System.out.println("letters = " + letters[i]);
        }
        int j = 0;
        int lengthP = p.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && j - i < p.length()){
                if(letters[s.charAt(j++) - 'a']-- > 0)
                    lengthP--;
            }
            if(lengthP == 0 && j - i == p.length())
                list.add(i);
            if(letters[s.charAt(i) - 'a']++ >= 0)
                lengthP++;
        }
        return list;
    }

    // Day 18 i solved this problem  the same as above just i will return true if it matches otherwise it will return false

    /**
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
     * In other words, one of the first string's permutations is the substring of the second string.
     * */

    public static boolean checkInclusion(String s1, String s2) {
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            // System.out.println("letters = " + letters[i]);
        }
        int j = 0;
        int lengthS1 = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            while (j < s2.length() && j - i < s1.length()){
                if(letters[s2.charAt(j++) - 'a']-- > 0)
                    lengthS1--;
            }
            if(lengthS1 == 0 && j - i == s1.length())
                return true;
            if(letters[s2.charAt(i) - 'a']++ >= 0)
                lengthS1++;
        }
        return false;
    }

    // Day 19
    /** Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

     The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

     For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
     */

    class StockSpanner {
        List<Integer> list;
        public StockSpanner() {
             list = new ArrayList<>();
        }

        public int next(int price) {
            int value = 0;
            list.add(price);
            for (int i = list.size() -1 ; i >= 0 ; i--) {
                if(price < list.get(i))
                    break;
                value++;
            }
            return value;
        }
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    // Day 20
    /**Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.*/
    int answer, count;
    public void inorder(TreeNode root, int k){
        if(root == null) return ;
        inorder(root.left, k);
        count++;
        if(count == k){
            answer = root.val;
            return ;
        }
        inorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        answer = 0;
        inorder(root, k);
        return answer;
    }

}
