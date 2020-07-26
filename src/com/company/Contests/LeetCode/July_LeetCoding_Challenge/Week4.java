package com.company.Contests.LeetCode.July_LeetCoding_Challenge;

import java.util.*;

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

    // Day 23 Single Number III
    /** Given an array of numbers nums, in which exactly two elements appear only once
     * and all the other elements appear exactly twice. Find the two elements that appear only once.*/

    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                set.remove(num);
            }
        }

        int i = 0;
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            result[i++] = itr.next();
        }

        return result;
    }
    // Day 24 All Paths From Source to Target
    /** Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
     The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for
     which the edge (i, j) exists.*/

    private void pathFromNode(int[][] graph, int idx, List<List<Integer>> res, List<Integer> path) {
        // return if node outdegree is 0 and it's not last node
        if(idx < graph.length-1 && graph[idx].length<1)
            return;
        // path found, add to result
        if(idx >= graph.length-1)
            res.add(path);

        // get path from all neighbours
        for(int v: graph[idx]) {
            // clone path found yet
            List<Integer> cp = new ArrayList(path);
            cp.add(v);
            pathFromNode(graph, v, res, cp);
        }

    }

    // Day 25 Find Minimum in Rotated Sorted Array II
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        path.add(0);
        // start from node 0
        pathFromNode(graph, 0, res, path);
        return res;
    }

    /** Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     Find the minimum element.
     The array may contain duplicates.
     */

    public int findMin(int[] nums) {
        int tail = nums[nums.length-1];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < tail)
                return nums[i];
        }
        return tail;
    }

}
