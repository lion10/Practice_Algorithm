package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}


