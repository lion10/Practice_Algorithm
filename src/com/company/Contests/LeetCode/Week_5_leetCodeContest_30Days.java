package com.company.Contests.LeetCode;

public class Week_5_leetCodeContest_30Days {


    public static void main(String[] args) {


    }




    /** 28th day:
     *Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the
     * parent-child connections.The path must contain at least one node and does not need to go through the root.
     * */
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

    class Solution {
        int maxPath ;
        public int maxPathSum(TreeNode root) {
            maxPath = Integer.MIN_VALUE;
            max_path_right_left(root);
            return maxPath;
        }

        int max_path_right_left(TreeNode root){
            if(root == null)
                return 0;

            int leftSide = Math.max(max_path_right_left(root.left),0);
            int rightSide = Math.max(max_path_right_left(root.right),0);

            int sum = root.val + leftSide +rightSide;
            maxPath = Math.max(maxPath,sum);

            return root.val +Math.max(leftSide,rightSide);
        }
    }
}