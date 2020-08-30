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


        //  Day 25: Minimum Cost For Tickets
        /**
         * In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
         * Train tickets are sold in 3 different ways:
         * a 1-day pass is sold for costs[0] dollars;
         * a 7-day pass is sold for costs[1] dollars;
         * a 30-day pass is sold for costs[2] dollars.
         * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
         * Return the minimum number of dollars you need to travel every day in the given list of days.*/

        int[] costs;
        Integer[] memo;
        Set<Integer> dayset;

        public int mincostTickets(int[] days, int[] costs) {
            this.costs = costs;
            memo = new Integer[366];
            dayset = new HashSet();
            for (int d: days) dayset.add(d);

            return dp(1);
        }

        public int dp(int i) {
            if (i > 365)
                return 0;
            if (memo[i] != null)
                return memo[i];

            int ans;
            if (dayset.contains(i)) {
                ans = Math.min(dp(i+1) + costs[0],
                        dp(i+7) + costs[1]);
                ans = Math.min(ans, dp(i+30) + costs[2]);
            } else {
                ans = dp(i+1);
            }

            memo[i] = ans;
            return ans;
        }


        // Day 26: Fizz Buzz
        /**
         * Write a program that outputs the string representation of numbers from 1 to n.
         * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
         * For numbers which are multiples of both three and five output “FizzBuzz”.*/
        public List<String> fizzBuzz(int n) {
            // ans list
            List<String> ans = new ArrayList<String>();

            for (int num = 1; num <= n; num++) {

                boolean divisibleBy3 = (num % 3 == 0);
                boolean divisibleBy5 = (num % 5 == 0);

                if (divisibleBy3 && divisibleBy5) {
                    // Divides by both 3 and 5, add FizzBuzz
                    ans.add("FizzBuzz");
                } else if (divisibleBy3) {
                    // Divides by 3, add Fizz
                    ans.add("Fizz");
                } else if (divisibleBy5) {
                    // Divides by 5, add Buzz
                    ans.add("Buzz");
                } else {
                    // Not divisible by 3 or 5, add the number
                    ans.add(Integer.toString(num));
                }
            }

            return ans;
        }


        // Day 27: Find Right Interval
        /**
         * Given a set of intervals, for each of the interval i, check if there exists an interval
         * j whose start point is bigger than or equal to the end point of the interval i,
         * which can be called that j is on the "right" of i.
         * For any interval i, you need to store the minimum interval j's index,
         * which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i.
         * Finally, you need output the stored value of each interval as an array.*/

        public int[] findRightInterval(int[][] intervals) {

            // edge cases
            int rows = intervals.length;
            if (rows == 0) return new int[0];
            if (rows < 2) return new int[]{-1};

            // save all start points into the map
            // start point - key.
            // interval index - value
            Map<Integer, Integer> map = new HashMap<>();
            // count max possible start point
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                int[] row = intervals[i];
                map.put(row[0], i);
                max = Math.max(max, row[0]);
            }

            // Create result array and fill with -1 for cases when no solution found
            int[] result = new int[rows];
            Arrays.fill(result, -1);
            // iterate over all intervals
            for (int i = 0; i < rows; i++) {
                int[] row = intervals[i];
                int min = row[1];
                // if interval end point is greater than max start point - there is no 'right' interval for it.
                // -1 will be saved for this interval
                if (min > max) {
                    continue;
                }
                // starting from nearest 'right' interval with start point equal to current end point
                // iterating and searching for the first interval fitting our expectations
                while (min <= max && result[i] == -1) {
                    if (map.containsKey(min)) {
                        result[i] = map.get(min);
                        break;
                    }
                    min++;
                }
            }
            return result;
        }





        //  Day 28: Implement Rand10() Using Rand7()
        /**Given the API rand7 which generates a uniform random integer in the range 1 to 7,
         * write a function rand10 which generates a uniform random integer in the range 1 to 10.
         * You can only call the API rand7 and you shouldn't call any other API. Please don't use
         * the system's Math.random().
         Notice that Each test case has one argument n, the number of times that your implemented
         function rand10 will be called while testing.
         Follow up:
         What is the expected value for the number of calls to rand7() function?
         Could you minimize the number of calls to rand7()?*/

        /*class Solution extends SolBase {

            */
            /**
             Lets take input is 1000.
             The count will get incremented by 1, every time the method rand10() is called.
             The idea here is to distribute values 1 to 10 equally.
             Let's say rand10() is called for 447th time.
             At this point c = 447
             and 447 % 10 + 1 = 7 + 1 = 8 will be returned.
             */
            /*

            // I comment the solution becuse I can not call SolBase Api
            // I implement it without using rand7() api
            int count = 1;
            public int rand10() {
                return (count++)%10 + 1;
            }

        }*/


    }
}
