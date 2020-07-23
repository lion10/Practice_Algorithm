package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Week4 {


    // Day 22 Binary Tree Zigzag Level Order Traversal
    /** Given a binary tree, return the zigzag level order traversal of its nodes' values.
     *  (ie, from left to right, then right to left for the next level and alternate between).
     */
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


    Stack<TreeNode> st1 = null;
    Stack<TreeNode> st2 = null;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){return res;}
        st1 = new Stack<TreeNode>();
        st2 = new Stack<TreeNode>();

        st1.add(root);

        int alt=1;
        TreeNode temp = null;

        int size=1;

        List<Integer> part = new ArrayList<>();
        while(st1.size()>0 || st2.size()>0){
            if(alt==1){
                temp = st1.pop();
                part.add(temp.val);
                if(temp.left!=null){
                    st2.push(temp.left);
                }
                if(temp.right!=null){
                    st2.push(temp.right);
                }
            }else{
                temp = st2.pop();
                part.add(temp.val);
                if(temp.right!=null){
                    st1.push(temp.right);
                }
                if(temp.left!=null){
                    st1.push(temp.left);
                }
            }

            if(part.size()==size){
                res.add(part);
                part=new ArrayList<>();
                if(alt==1){alt=0; size=st2.size();}
                else{alt=1;size=st1.size();}
            }
        }

        return res;
    }
}
