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

    // Day 10 Flatten a Multilevel Doubly Linked List

    /** You are given a doubly linked list which in addition to the next and previous pointers, it could have a child
     *  pointer,
     *  which may or may not point to a separate doubly linked list. These child lists may have one or more children of
     *  their own, and so on, to produce a multilevel data structure,
     *  as shown in the example below. Flatten the list so that all the nodes appear in a single-level, doubly linked list.
     *  You are given the head of the first level of the list.*/

    public class Node1 {
        public int val;
        public Node1 prev;
        public Node1 next;
        public Node1 child;
    };

    public Node1 flatten(Node1 head) {
        Stack<Node1> stack = new Stack<>();
        Node1 current = head,tail = head;
        while(current != null){
            if(current.child != null){
                Node1 child = current.child;
                if(current.next!=null){
                    current.next.prev=null;
                    stack.push(current.next);
                }
                current.next=child;
                current.child=null;
                child.prev = current;
            }
            tail=current;
            current=current.next;
        }
        while(!stack.isEmpty()){
            current = stack.pop();
            tail.next=current;
            current.prev = tail;
            while(current!=null){
                tail=current;
                current=current.next;
            }
        }
        return head;
    }

    // Day 11 Subsets
    /** Given a set of distinct integers, nums, return all possible subsets (the power set).

     Note: The solution set must not contain duplicate subsets.*/

    List<List<Integer>> output = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<Integer>());
        return output;
    }

    public void dfs(int index, int[] nums, ArrayList<Integer> list) {
        if (index == nums.length) {
            output.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[index]);
        dfs(index+1, nums, list);
        list.remove(list.size()-1);
        dfs(index+1, nums, list);
    }

    // Day 12 Reverse Bits
    /** Reverse bits of a given 32 bits unsigned integer.*/

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }


    // Day 13 Same Tree

    /** Given two binary trees, write a function to check if they are the same or not.
     Two binary trees are considered the same if they are structurally identical and the nodes have the same value.*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return q.val == p.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
