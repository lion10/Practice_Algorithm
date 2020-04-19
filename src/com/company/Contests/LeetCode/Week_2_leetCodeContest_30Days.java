package com.company.Contests.LeetCode;

import java.util.*;

public class Week_2_leetCodeContest_30Days {


    public static void main(String[] args) {

        // 8th day
        // System.out.println(backspaceCompare("ab#c", "ad#c"));


        // 9th day :
        // Your MinStack object will be instantiated and called as such:
        /*
               MinStack obj = new MinStack();
               int[] arr = {1,2,3};
               for (int i = 0; i < arr.length; i++) {
                    obj.push(arr[i]);
                }
               obj.pop();
               int param_3 = obj.top();
               int param_4 = obj.getMin();
                System.out.println("param_3 = " + param_3);
                System.out.println("param_4 = " + param_4);
        */


        //10th day :

       /* Solution tree = new Solution();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("longest path = " + tree.diameterOfBinaryTree(tree.root));*/

        // 11th day :
//        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));

        // 12th day
   //     System.out.println(findMaxLength(new int[]{0,1,0}));


        //13th day

        System.out.println(shiftRight("omar",4));
        System.out.println(shiftLeft("omar",4));
        System.out.println(stringShift("abc",
                new int[][]{{0,1},{1,2}}
                ));



    }



    /** 7th day : Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     If there are two middle nodes, return the second middle node.
     */

   // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
            int length = 0 ;
            ListNode node = head;
            while(node.next != null){
                length++;
                node = node.next;
            }
            ListNode node1 = head;
            int length1 = 0 ;

            if(length % 2 == 0){
                while(isaBoolean(node1, length1, length / 2)){
                    length1++;
                    node1 = node1.next;
                }
            } else{
                while(isaBoolean(node1, length1, (length/ 2)+1)){
                    length1++;
                    node1 = node1.next;
                }
            }

            return node1 ;
    }

    private boolean isaBoolean(ListNode node1, int length1, int i) {
        return node1.next != null && length1 < (i);
    }


    /** 8th day
     * Given two strings S and T, return if they are equal when both are typed into empty text editors.
     * # means a backspace character.
     * */

    public static boolean backspaceCompare(String S, String T) {
        return strWithOutHash(S).equals(strWithOutHash(T));
    }

    public static String strWithOutHash(String str){
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#')
                buf.append(str.charAt(i));
            else if (buf.length() != 0)
                buf.setLength(buf.length() - 1);
           // System.out.println("buf = " + buf);
        }
        return buf.toString();
    }

    /** 9th day
     *Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     * */
    static class MinStack {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStack() {
            stack1 =  new Stack<>();
            stack2 =  new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.isEmpty()){
                stack2.push(x);
            }else{
                stack2.push(Math.min(x,stack2.peek()));
            }

        }

        public void pop() {
            stack1.pop();
            stack2.pop();

        }

        public int top() {
            return stack1.peek();

        }

        public int getMin() {
            return stack2.peek();
        }
    }
    /** 10th day :
    * Given a binary tree, you need to compute the length of the diameter of the tree.
    * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    * This path may or may not pass through the root.
    * */

    /**
     * Definition for a binary tree node.
     * */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        TreeNode root;
        int max = 0 ;

        public int diameterOfBinaryTree(TreeNode root) {
                maxDepth(root);
                return max;
        }
        public int maxDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            int rightDepth = maxDepth(root.right);
            int leftDepth = maxDepth(root.left);

            max = Math.max (max , rightDepth + leftDepth);

            return Math.max(rightDepth , leftDepth) + 1;
        }
    }


    /** 11th day :
     * We have a collection of stones, each stone has a positive integer weight.
     *
     * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
     *
     * If x == y, both stones are totally destroyed;
     * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
     * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
     * **/
    public static int lastStoneWeight(int[] stones) {
        if(stones==null)
            return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.offer(stones[i]);
        }
        while (priorityQueue.size() > 1) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            if (first != second) {
                int rem = Math.abs(first - second);
                priorityQueue.offer(rem);
            }
        }
        return priorityQueue.size()==1 ? priorityQueue.poll() : 0;
    }


/** 12th day
*
* Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 */
    public static int findMaxLength(int[] nums) {

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);
                int maxLength = 0;
                int  count = 0;
                for (int i = 0; i < nums.length; i++) {
                    count = count + (nums[i] == 1 ? 1 : -1);
                    if (map.containsKey(count)) {
                        maxLength = Math.max(maxLength, i - map.get(count));
                    } else {
                        map.put(count, i);
                    }
                }
        return maxLength ;
    }


    /** 13th day
        *
        * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
        *
        * direction can be 0 (for left shift) or 1 (for right shift).
        * amount is the amount by which string s is to be shifted.
        * A left shift by 1 means remove the first character of s and append it to the end.
        * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
        * Return the final string after all operations.
        */

    public static String stringShift(String s, int[][] shift) {
        int countShiftTimes = countTimeOfShiftRightAndLeft(shift);
        String result;
        if(countShiftTimes == 0){
            result = s;
        }else if(countShiftTimes > 0){
               result = shiftLeft(s,countShiftTimes);
        }else {
            result = shiftRight(s,Math.abs(countShiftTimes));
        }
        return result;
    }


    public static int countTimeOfShiftRightAndLeft(int[][] shift){
        int totalShiftLeft = 0 ;
        for (int i = 0; i < shift.length ; i++) {
            if(shift[i][0] == 0 ){
                totalShiftLeft += shift[i][1];
            }else if(shift[i][0] == 1) {
                totalShiftLeft -= shift[i][1];
            }
        }
      return totalShiftLeft;
    }

    public static String shiftRight(String s , int times) {
        String temp = s;
        for (int i = 0; i < times ; i++) {
            temp =  temp.charAt(temp.length()-1)+temp.substring(0, temp.length()-1);
        }
        return temp;
    }

    public static String shiftLeft(String s ,int times) {
        String temp = s;
        for (int i = 0; i < times; i++) {
          temp = temp.substring(1) + temp.charAt(0);
        }
        return temp;
    }



}


