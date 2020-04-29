package com.company.Contests.LeetCode;

import java.util.*;

public class Week_4_leetCodeContest_30Days {

    public static void main(String[] args) {
        // 21th day:
        // System.out.println(subarraySum(new int[]{1,2,2},2));

        // 22th day:
        //System.out.println(rangeBitwiseAnd(5,7));

        // 24th day:
       // System.out.println(canJump(new int[]{2,0}));


        //25th day
      //  System.out.println(longestCommonSubsequence("abc","abc"));


        // 26th day
        Scanner scan=new Scanner(System.in);
        char inputArray[][] = new char[4][5];

        for (int i = 0; i < 4; i++) {
            String data = "";
            if (scan.hasNext()) { // input from user
                data = scan.next();
            } else {
                break;
            }
            for (int j = 0; j < 5; j++)
                inputArray[i][j] = data.charAt(j);
        }

        System.out.println(maximalSquare(inputArray));
    }


    /** 21th day:
     Given an array of integers and an integer k, you need to find the total number of
     continuous subarrays whose sum equals to k.
     */


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int j = 0;
        while (j < nums.length){
            int total = 0;
            for (int i = j; i < nums.length ; i++) {
                total += nums[i];
                if(total == k){
                    count++;
                    // break; //  if i put here break then this case not get the result exactly [0,0,0,0,0] and k = 0
                }
            }
            j++;
        }
        return count;
    }

    /** 22th day:
     Given an array of integers and an integer k, you need to find the total number of
     continuous subarrays whose sum equals to k.
     */

    public static int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        while(n > m){
            n = n & n-1;
        //    System.out.println(n);
        }
        return  n;
    }
    /** 23th day:
     Design and implement a data structure for Least Recently Used (LRU) cache. It should support
     the following operations: get and put.
     */

    class LRUCache {

        HashMap<Integer,Integer> map;
        List<Integer> list;
        int c;

        public LRUCache(int capacity) {
            c=capacity;
            list=new ArrayList<>(capacity);
            map=new HashMap<>();
        }

        public int get(int key) {
            if(map.containsKey(key)){
                int temp=list.indexOf(key);
                list.remove(temp);
                list.add(key);
                return map.get(key);
            }
            return -1;

        }

        public void put(int key, int value) {
            if(list.contains(key)){
                map.put(key,value);
                int temp=list.indexOf(key);
                list.remove(temp);
                list.add(key);
            }else{
                if(list.size()==c){
                    int temp=list.get(0);
                    map.remove(temp);
                    list.remove(0);
                }
                list.add(key);
                map.put(key,value);
            }
        }
    }


    /** 24th day:
     Given an array of non-negative integers, you are initially positioned at the first index of the array.
     Each element in the array represents your maximum jump length at that position.
     Determine if you are able to reach the last index.
     */

    public static boolean canJump(int[] nums) {
      /*  int index = 1 ;
        while (index < nums.length){
            index += nums[index-1];
            // System.out.println(index);
            if(index > nums.length ){
                return false;
            }
            if(index == nums.length ){
                return true;
            }
            if(nums[index-1]==0 && index < nums.length )
                return false;
        }
        return index == nums.length? true :false;
        */

        int index = 0 ;
        for(int i=0;i<nums.length;i++) {
            if(index < i)
                return false;
            if(i + nums[i] >= nums.length-1)
                return true;
            index= Math.max(index, i+nums[i]);
        }
        return index >= nums.length-1;
    }


    /** 25th day:
     Given two strings text1 and text2, return the length of their longest common subsequence.
     */

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] x = text1.toCharArray();
        char[] y= text2.toCharArray();
        int n= text1.length();
        int m =text2.length();

        int[][] lcs = new int[n + 1][m + 1];

        if(text1 == null || text2 == null)
            return 0;

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (x[i - 1] == y[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                }else {
                    lcs[i][j] =Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        return lcs[n][m];

    }


    /** 26th day:
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
     * */
    public static int maximalSquare(char[][] matrix) {
//        int count = 0;
//        int startWidth = 0;
//        int startLength = 0;
//        if(matrix[0].length == 1){
//            for (int i = 0; i < matrix.length ; i++) {
//                if (matrix[0][i] == '1')
//                    return 1;
//                else
//                    return 0;
//
//            }
//        }
//        for (int i = 0; i <matrix.length-1 ; i++) {
//            for (int j = 0; j <matrix[i].length-1; j++) {
//                if(matrix[i][j] == '1' && matrix[i][j+1] == '1' ){
//                    startWidth  += 2;
//                    System.out.println("startWidth = " + startWidth);
//                    if (matrix[i+1][j] == '1' && matrix[i+1][j+1] == '1'){
//                        startLength += 2;
//                        System.out.println("startLength = " + startLength);
//                        if(startLength == startWidth)
//                            count+=4;
//                        else {
//                            startWidth =0;
//                            startLength =0;
//                        }
//                    }
//                    if(i + 4 > matrix.length-1 || j + 4 > matrix[i].length-1) {
//                        startWidth =0;
//                        startLength =0;
//                        break;
//                    }
//                }else{
//                    startWidth =0;
//                    startLength =0;
//                }
//            }
//        }
//        return count;


        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int len = 1;
                    boolean flag = true;
                    while (len + i < rows && len + j < cols && flag) {
                        for (int k = j; k <= len + j; k++) {
                            if (matrix[i + len][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= len + i; k++) {
                            if (matrix[k][j + len] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            len++;
                    }
                    if (maxlen < len) {
                        maxlen = len;
                    }
                }
            }
        }
        return maxlen * maxlen;

    }

    /** 27th day:
     * You have a queue of integers, you need to retrieve the first unique integer in the queue.
     * * Implement the FirstUnique class:
     * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
     * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
     * void add(int value) insert value to the queue.
     * */

    class FirstUnique {

        /** 14/17 test cases accepted*/
        /*
        Queue<Integer> queue;
        HashMap<Integer,Integer> hashMap;
        public FirstUnique(int[] nums) {
             queue =new LinkedList<>();
             hashMap= new HashMap<>();
            for (int a: nums) {
                if(!hashMap.containsKey(a)){
                    hashMap.put(a,1);
                    queue.add(a);
                }
                else{
                    queue.remove(a);
                    hashMap.remove(a);
                }
            }
        }

        public int showFirstUnique() {
            Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
            // flag to store result
            int keyToBeChecked = 1;
            boolean isKeyPresent = false;
            // Iterate over the HashMap
            while (iterator.hasNext()) {
                // Get the entry at this iteration
                Map.Entry<Integer, Integer> entry  = iterator.next();
                // Check if this key is the required key
                if (keyToBeChecked == entry.getKey()) {
                    isKeyPresent = true;
                }
            }

            return isKeyPresent? queue.peek():-1;
        }

        public void add(int value) {
            queue.add(value);
            if(!hashMap.containsKey(value)){
                hashMap.put(value,1);
                queue.add(value);
            }
            else{
                hashMap.put(value,hashMap.get(value)+1);
                queue.remove(value);
            }
        }*/


        /** anther solution*/
        HashSet<Integer> unique = new LinkedHashSet<>(),
                nonunique = new LinkedHashSet<>();

        public FirstUnique(int[] nums) {
            for (int num: nums) {
                add(num);
            }
        }
        public int showFirstUnique() {
            try {
                return unique.iterator().next();
            }catch (NoSuchElementException e){
                return -1;
            }
        }
        public void add(int value) {
            if(nonunique.contains(value)) return;
            if(unique.contains(value)){
                unique.remove(value);
                nonunique.add(value);
                return;
            }
            unique.add(value);
        }

    }
}
