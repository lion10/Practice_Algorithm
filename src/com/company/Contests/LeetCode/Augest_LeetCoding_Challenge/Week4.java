package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.*;

public class Week4 {



    // Day 22: Random Point in Non-overlapping Rectangles
    /**
     * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
     * Note:
     * An integer point is a point that has integer coordinates.
     * A point on the perimeter of a rectangle is included in the space covered by the rectangles.
     * ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
     * length and width of each rectangle does not exceed 2000.
     * 1 <= rects.length <= 100
     * pick return a point as an array of integer coordinates [p_x, p_y]
     * pick is called at most 10000 times.*/
    class Solution {
        private int[][] rects;
        private Random r;
        private TreeMap<Integer, Integer> map;
        private int area;
        public Solution(int[][] rects) {
            this.rects = rects;
            r = new Random();
            map = new TreeMap<>();
            area = 0;
            for (int i = 0; i < rects.length; i++) {
                area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
                map.put(area, i);
            }
        }
        public int[] pick() {
            int randInt = r.nextInt(area);
            int key = map.higherKey(randInt);
            int[] rect = rects[map.get(key)];
            int x = rect[0] + (key - randInt - 1) % (rect[2] - rect[0] + 1);
            int y = rect[1] + (key - randInt - 1) / (rect[2] - rect[0] + 1);
            return new int[]{x, y};
        }




        class Trie {

            Trie[] children;
            boolean isEnd;

            public Trie () {
                children = new Trie[26];
                isEnd = false;
            }
        }



        // Day 23:  Stream of Characters
        /** Implement the StreamChecker class as follows:

         StreamChecker(words): Constructor, init the data structure with the given words.
         query(letter): returns true if and only if for some k >= 1, the last k characters
         queried (in order from oldest to newest,
         including this letter just queried) spell one of the words in the given list.*/
        class StreamChecker {

            Trie root;
            List<Character> list;

            public StreamChecker (String[] words) {

                root = new Trie ();
                list = new LinkedList<>();

                for (String word : words) {
                    insertWord (word);
                }
            }

            public void insertWord (String word) {

                Trie node = root;

                for (int i = word.length () - 1; i >= 0; i--) {
                    char letter = word.charAt (i);
                    if (node.children[letter - 'a'] == null) {
                        node.children[letter - 'a'] = new Trie ();
                    }
                    node = node.children[letter - 'a'];
                }

                node.isEnd = true;
            }

            public boolean query (char letter) {

                list.add (letter);
                return searchWord ();
            }

            public boolean searchWord () {

                Trie node = root;
                for (int i = list.size () - 1; i >= 0; i--) {
                    char letter = list.get (i);
                    if (node.children[letter - 'a'] == null) {
                        return false;
                    }
                    node = node.children[letter - 'a'];
                    if (node.isEnd) {
                        return true;
                    }
                }

                return false;
            }
        }




        // Day 24:  Stream of Characters

        /** Find the sum of all left leaves in a given binary tree.
         */

       public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        int result=0;
        public int sumOfLeftLeaves(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            return result;
        }

        public void dfs(TreeNode root){
            if(root.left!=null){
                if(root.left.left==null && root.left.right==null){
                    result+=root.left.val;
                }
                dfs(root.left);
            }
            if(root.right!=null){
                dfs(root.right);
            }
        }
    }
}
