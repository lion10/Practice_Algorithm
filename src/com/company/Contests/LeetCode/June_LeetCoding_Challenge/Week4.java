package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Week4 {

    public static void main(String[] args) {

    }

    // Day 22 Single Number II

    /** Given a non-empty array of integers, every element appears three times except for one,
     which appears exactly once. Find that single one.
     */
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> numMap = new HashMap<>();

        for (int i=0; i < nums.length; i++)
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);


        for (Map.Entry<Integer,Integer> num : numMap.entrySet())
            if (num.getValue() != 3)
                return num.getKey();

        return 0;
    }



 //  Day 23 Count Complete Tree Nodes
    /** Given a complete binary tree, count the number of nodes.*/
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


     public int countNodes(TreeNode root) {
          if(root==null)
              return 0;
          if(root.left==null && root.right==null)
              return 1;
          if(root.left!=null && root.right==null)
              return 2;
          return 1+countNodes(root.left)+countNodes(root.right);
    }

    // Day 24  Unique Binary Search Trees
    /** Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n? */

    public int numTrees(int n) {
        int total[]= new int[n+1];
        total[0]=1;
        total[1]=1;

        for(int i = 2;i <= n; i++){
            for(int j = 0; j < i; j++){
                total[i] += total[j] * total[i-j-1];
            }
        }
        return total[n];
    }

    // Day 25 Find the Duplicate Number
    /** Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
     *  prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
     * find the duplicate one.*/


    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }


    // use hash map
    public int findDuplicate2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (numSet.add(nums[i]) == false)
                return nums[i];
        }

        return 0;
    }

    //Day 27  Sum Root to Leaf Numbers

    /** Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

     An example is the root-to-leaf path 1->2->3 which represents the number 123.

     Find the total sum of all root-to-leaf numbers.

     Note: A leaf is a node with no children.*/
    public int sumNumbers(TreeNode root) {
        return sumToLeaf(0, root);
    }
    int sumToLeaf(int current, TreeNode root){
        if(root == null)
            return 0;
        current = (10*current) + root.val;
        if(root.left == null && root.right == null)
            return current;
        return sumToLeaf(current, root.left) + sumToLeaf(current, root.right);
    }

    // Day 27 Perfect Squares
    /** Given a positive integer n, find the least number of perfect square numbers
    (for example, 1, 4, 9, 16, ...) which sum to n.
    */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            int square = (int)Math.sqrt(i);
            if (square * square == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= square; j++) {
                int dif = i - j * j;
                dp[i] = Math.min(dp[i], (dp[dif] + 1));
            }
        }

        return dp[n];
    }

}
