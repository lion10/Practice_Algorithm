package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

import java.util.*;

public class Week2 {
    public static void main(String[] args) {

    }

    // Day 8 3Sum

    /** Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     *  Find all unique triplets in the array which gives the sum of zero.
     *  Note:
     *  The solution set must not contain duplicate triplets.*/

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                break;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // Skip duplicate numbers of j
                    while (j+1 <= k && nums[j] == nums[j+1])
                        j++;
                    j++;
                    k--;
                }
            }
            // Skip duplicate numbers of i
            while (i+1 < n && nums[i+1] == nums[i])
                i++;
        }
        return ans;
    }

    // Day 9 Maximum Width of Binary Tree
    /** Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree
     *  is the maximum width among all levels. The binary tree
     *  has the same structure as a full binary tree, but some nodes are null.
     * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null
     * nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.*/

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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int maxWidth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root,0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftPos = queue.peek().pos, rightPos = 0;

            for(int i = 0;i < size; i++) {

                Node temp = queue.poll();
                if (temp.treeNode.left != null)
                    queue.offer(new Node(temp.treeNode.left,2 * temp.pos + 1));

                if (temp.treeNode.right != null)
                    queue.offer(new Node(temp.treeNode.right,2 * temp.pos + 2));

                if (i == size -1)
                    rightPos = temp.pos;
            }

            maxWidth = Math.max(maxWidth, rightPos - leftPos + 1);

        }

        return maxWidth;

    }

    public class Node{
        int pos;
        TreeNode treeNode;
        public Node(TreeNode treeNode, int val) {
            this.treeNode = treeNode;
            this.pos = val;
        }
    }
}
