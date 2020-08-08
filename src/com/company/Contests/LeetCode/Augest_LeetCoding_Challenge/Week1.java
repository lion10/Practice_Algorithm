package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.*;

public class Week1 {



    // Day 1: Detect Capital
    /**Given a word, you need to judge whether the usage of capitals in it is right or not.

     We define the usage of capitals in a word to be right when one of the following cases holds:

     All letters in this word are capitals, like "USA".
     All letters in this word are not capitals, like "leetcode".
     Only the first letter in this word is capital, like "Google".
     Otherwise, we define that this word doesn't use capitals in a right way.*/
    public boolean detectCapitalUse(String word) {
        int lastCap = -1;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                if(lastCap + 1 == i) {
                    lastCap++;
                } else {
                    return false;
                }
            }
        }
        if(lastCap == -1 || lastCap == word.length() - 1 || lastCap == 0) {
            return true;
        }
        return false;
    }


    // Day 2: Design HashSet

    /**
     * Design a HashSet without using any built-in hash table libraries.
     * To be specific, your design should include these functions:
     * add(value): Insert a value into the HashSet.
     * contains(value) : Return whether the value exists in the HashSet or not.
     * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
     * */

    class MyHashSet {
        ArrayList<Integer> arrayList;
        /** Initialize your data structure here. */
        public MyHashSet() {
            arrayList = new ArrayList<>();
        }

        public void add(int key) {
            if (!arrayList.contains(key))
                arrayList.add(key);
        }

        public void remove(int key) {
            Integer val = new Integer(key);
            arrayList.remove(val);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return arrayList.contains(key);
        }
    }

    // Day 3: Valid Palindrome
    /** Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     Note: For the purpose of this problem, we define empty string as valid palindrome.*/

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;

        while(start < end) {
            if (!isAlphaNum(s.charAt(start))) {
                start++;
                continue;
            }

            if (!isAlphaNum(s.charAt(end))) {
                end--;
                continue;
            }

            if (!isEqual(s.charAt(start),s.charAt(end)))
                return false;

            start++;
            end--;
        }
        return true;
    }

    boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    boolean isAlphaNum(char c) {
        return isAlpha(c) || isNum(c);
    }

    boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    boolean isEqual(char c1, char c2) {
        return Math.abs(c1 - c2) == 0 || (Math.abs(c1 - c2) == 32 && !isNum(c1) && !isNum(c2));
    }


    // Day 4: Power of Four
    /** Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
     */
    public boolean isPowerOfFour(int num) {
        double res = Math.log10(num) / Math.log10(4);
        if(res - (int)res == 0)
            return true;
        else
            return false;
    }
    // Day 5: Add and Search Word - Data structure design

    /** Design a data structure that supports the following two operations:
     * void addWord(word)
     * bool search(word)
     * search(word) can search a literal word or a regular expression
     * string containing only letters a-z or .. A . means it can represent any one letter.
     */


    class WordDictionary {

        private Map<Integer, List<String>> map;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            map = new HashMap<>();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            int len = word.length();
            if (!map.containsKey(len))
                map.put(len, new ArrayList<>());
            map.get(len).add(word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            int len = word.length();
            if (!map.containsKey(len)) return false;
            for (String s : map.get(len)) {
                if (match(s, word)) return true;
            }
            return false;
        }


        private boolean match(String s, String t) {
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != '.' && t.charAt(i) != s.charAt(i))
                    return false;
            }
            return true;
        }
    }


    //Day 6: Find All Duplicates in an Array
    /** Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     Find all the elements that appear twice in this array.
     Could you do it without extra space and in O(n) runtime?
     */

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList <>();
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs (nums[i]) - 1;
            if (nums[pos] < 0) {
                ans.add (++pos);
            }
            else {
                nums[pos] *= -1;
            }
        }
        return ans;
    }




    //Day 7: Vertical Order Traversal of a Binary Tree
    /**
     Given a binary tree, return the vertical order traversal of its nodes values.
     For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
     Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
     If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
     Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
     */


    class Solution {

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

        HashMap<Integer, HashMap> map = null;

        int min_x = 0;
        int max_x = 0;

        int min_y = 0;
        //max_y will always be 0;

        public List<List<Integer>> verticalTraversal(TreeNode root) {

            map = new HashMap<Integer, HashMap>(); //map to store x

            int x = 0;
            int y = 0;

            traverseTree(root, x, y);

            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            for (x = min_x; x <= max_x; x++) {
                if(map.containsKey(x)) {
                    HashMap<Integer, ArrayList<Integer>> subMap = map.get(x);
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    for(y = 0; y >= min_y; y-- ) {
                        if(subMap.containsKey(y)){
                            ArrayList<Integer> list = subMap.get(y);
                            Collections.sort(list);
                            for(int i : list){
                                arr.add(i);
                            }
                        }
                    }
                    result.add(arr);
                }
            }

            return (List) result;
        }

        public void traverseTree(TreeNode treeNode, int x, int y){

            HashMap<Integer, ArrayList<Integer>> subMap = null;

            if(x < min_x)
                min_x = x;
            if(x > max_x)
                max_x = x;
            if(y < min_y)
                min_y = y;

            if( map.containsKey(x) )
                subMap = map.get(x);
            else {
                subMap = new HashMap<Integer, ArrayList<Integer>>();
                map.put(x, subMap);
            }

            ArrayList<Integer> list = null;
            if(subMap.containsKey(y)) {
                list = subMap.get(y);
            } else {
                list = new ArrayList<Integer>();
                subMap.put(y, list);
            }

            list.add(treeNode.val);

            if(treeNode.left != null)
                traverseTree(treeNode.left, x-1, y-1);
            if(treeNode.right != null)
                traverseTree(treeNode.right, x+1, y-1);
        }

    }
}


