package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.ArrayList;

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


}
