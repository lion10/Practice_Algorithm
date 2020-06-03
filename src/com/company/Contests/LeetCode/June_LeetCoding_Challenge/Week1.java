package com.company.Contests.LeetCode.June_LeetCoding_Challenge;

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



}
