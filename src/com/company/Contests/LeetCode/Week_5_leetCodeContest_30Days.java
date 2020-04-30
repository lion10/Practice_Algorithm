package com.company.Contests.LeetCode;

public class Week_5_leetCodeContest_30Days {


    public static void main(String[] args) {


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

    class Solution {


        /** 28th day:
         *Given a non-empty binary tree, find the maximum path sum.
         *
         * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the
         * parent-child connections.The path must contain at least one node and does not need to go through the root.
         * */

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



        /** 29th day :
         * "Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given
         *  string is a valid sequence in such binary tree.
         * We get the given string from the concatenation of an array of integers arr and the concatenation of
         * all values of the nodes along a path results in a sequence in the given binary tree.
         */

            /* Time Limit Exceeded*/
         boolean isValidSequence(TreeNode root, int[] arr) {
     /*       TreeNode current = root;
            boolean temp = false;
            boolean temp2 = false;
            for(int i= 0;i <arr.length ; i++){
                while (current.left != null){
                    if((arr[i]== current.val || arr[i]== current.val )){
                        current = current.left;
                    }
                    if(current.right == null || arr[i]== current.val )
                        temp = true;
                }

                while(current.right != null){
                    if((arr[i]== current.val || arr[i]== current.val )){
                        current = current.right;
                    }
                    if(current.left == null ||arr[i]== current.val)
                        temp2 = true;
                }
            }
            return temp && temp2;*/

            /** anther solution*/
            return  checkPath(root ,arr, 0);

        }
        boolean checkPath(TreeNode root, int[] arr , int index){
             if(index == arr.length || root == null){
                 return false;
             }
             if(root.left == null && root.right == null && root.val == arr[index] && index == arr.length-1)
                 return true;
            return root.val == arr[index] && checkPath(root.left,arr,index+1) || checkPath(root.right,arr,index+1);

        }

    }
}