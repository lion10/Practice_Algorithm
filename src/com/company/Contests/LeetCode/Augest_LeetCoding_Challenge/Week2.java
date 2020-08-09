package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

public class Week2 {


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

    //Day 8 :  Path Sum III

    /** You are given a binary tree in which each node contains an integer value.
     Find the number of paths that sum to a given value.
     The path does not need to start or end at the root or a leaf, but it must
     go downwards (traveling only from parent nodes to child nodes).
     The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     */

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int cur = process(root,sum);
        return cur + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    private int process(TreeNode root,int remain){
        if(root == null) return 0;
        int cur = 0;
        if(root.val == remain) cur = 1;
        return cur + process(root.left,remain - root.val) + process(root.right,remain -root.val);
    }
}
