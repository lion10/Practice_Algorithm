package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

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

}
