package com.company.Contests;

import java.util.Stack;

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


}

