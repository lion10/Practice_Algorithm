package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Week1 {

    public static void main(String[] args) {

    }

    // Day 1
    /** Invert a binary tree.*/

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // Day 2
    /** Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

     Given linked list -- head = [4,5,1,9], which looks like following:*/
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Day 3
    /** There are 2N people a company is planning to interview. The cost of flying the i-th person to city
     * A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
     Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.*/

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b)->
                Integer.compare(a[0]-a[1], b[0]-b[1])
        );
        int result = 0;
        for(int i = 0; i < costs.length; i++)
            result += costs[i][i < costs.length/2 ? 0 : 1];

        return result;

    }

    // Day 4
    /** Write a function that reverses a string. The input string is given as an array of characters char[].

     Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

     You may assume all the characters consist of printable ascii characters.*/

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j)
            swap (s, i++, j--);
    }

    public void swap(char[] s, int i, int j) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }

    //Day 5
    /**Given an array w of positive integers, where w[i] describes the weight of index i,
     * write a function pickIndex which randomly picks an index in proportion to its weight.*/

    class Solution {

        private double[] probabilities;
        public Solution(int[] w) {
            double sum = 0;
            this.probabilities = new double[w.length];
            for(int weight : w)
                sum += weight;
            for(int i = 0; i < w.length; i++){
                w[i] += (i == 0) ? 0 : w[i - 1];
                probabilities[i] = w[i]/sum;
            }
        }
        public int pickIndex() {
            return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
        }
    }

    // Day 6
    /** Suppose you have a random list of people standing in a queue. Each person is described by a pair
     *  of integers (h, k), where h is the height of the person and k is the number of people in front of
     *  this person who have a height greater than or equal to h.
     *  Write an algorithm to reconstruct the queue.*/

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                else
                    return a[1] - b[1];
            }
        });

        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            tmp.add(people[i][1], people[i]);
        }

        int[][] res = new int[people.length][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }

        return res;
    }

    // Day 7
    /** You are given coins of different denominations and a total amount of money. Write a function
     * to compute the number of combinations that make up that amount.
     *  You may assume that you have infinite number of each kind of coin.*/
    public int change(int amount, int[] coins) {

        int[] tmp = new int[amount + 1];
        tmp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                tmp[i] += tmp[i-coin];
            }
        }
        return tmp[amount];

    }





}

