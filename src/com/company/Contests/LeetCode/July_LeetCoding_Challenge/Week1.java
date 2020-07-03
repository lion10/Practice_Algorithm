package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Week1 {
    public static void main(String[] args) {

    }
    // Day 1 Arranging Coins
    /** You have a total of n coins that you want to form in a staircase shape, where every k-th
     * row must have exactly k coins.
     Given n, find the total number of full staircase rows that can be formed.
     n is a non-negative integer and fits within the range of a 32-bit signed integer.*/
    public int arrangeCoins(int n) {
        int count = 0;
        for (int i = 1 ; i <=n ; i++){
            if ( n <= 0 )
                break;
            n -=i;
            count++;
        }
        return count;
    }



    // Day 2 Binary Tree Level Order Traversal II
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
    /** Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     *  (ie, from left to right, level by level from leaf to root).
     For example:
     Given binary tree [3,9,20,null,null,15,7],*/

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int count = q.size();
            while (count != 0){
                TreeNode temp = q.poll();
                list1.add(temp.val);
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
                count--;
            }
            list.add(list1);
        }
        Collections.reverse(list);
        return list;
    }

}
