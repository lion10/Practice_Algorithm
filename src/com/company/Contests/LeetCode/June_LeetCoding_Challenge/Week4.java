package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

import java.util.HashMap;
import java.util.Map;

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
}
