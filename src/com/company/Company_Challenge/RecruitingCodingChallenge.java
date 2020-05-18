package com.company.Company_Challenge;

import java.util.*;

public class RecruitingCodingChallenge {
    public static void main(String[] args) {

        System.out.println("hi all ");
        List<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(10);
        test.add(80);
        int a = finalInstance(1,test);
        System.out.println(a);
    }


    // 1st question
        public static int finalInstance(int instances, List<Integer> averageUtil){
            // 7/15 cases passed

            if(averageUtil.size() == 0 || averageUtil == null || instances == 0)
                return 0;
            int time = 0;
            while(time < averageUtil.size()){
                int averageUtilization = averageUtil.get(time);
                if(averageUtilization > 60 && instances <= 2e8){
                    instances = instances * 2;
                    time = time + 10;
                } else if(averageUtilization < 25 && instances > 1){
                    instances = (int) Math.ceil(instances / 2);
                    time = time + 10;
                } else if (averageUtilization >= 25 && averageUtilization <= 60){
                    time = time + 1;
                    continue;
                }
                time = time + 1;
            }
            return instances;

            // 6/15 cases passed
            /*if(averageUtil.size() == 0 || averageUtil == null || instances == 0)
                return 0;
            int time = 0;
            while(time < averageUtil.size()){
                int averageUtilization = averageUtil.get(time);
                if(averageUtilization > 60 ){
                    instances = instances * 2;
                    if(instances <= 2e8){
                        time = time + 10;
                    }
                } else if(averageUtilization < 25){
                    instances = (int) Math.ceil(instances / 2);
                    if( instances >= 1){
                        time = time + 10;
                    }
                } else if (averageUtilization >= 25 && averageUtilization <= 60){
                    time = time + 1;
                    continue;
                }
                time = time + 1;
            }
            return instances;*/
        }

        // 2nd question
        public static int maxHeight(List<Integer> tablePositions, List<Integer> tableHeights) {
            int max = 0;
            for(int i = 1; i < tablePositions.size(); i++){
                if(Math.abs(tablePositions.get(i-1) - tablePositions.get(i)) > 1){
                    max = Math.max(max, getMaxHeight(tablePositions.get(i-1), tablePositions.get(i), tableHeights.get(i-1), tableHeights.get(i)));
                }
            }
            return max;
        }


        public static int getMaxHeight(int t1, int t2, int h1, int h2){
            int shorter = Math.min(h1, h2);
            int taller = Math.max(h1, h2);
            int gap = Math.abs(t2 - t1) - 1;
            if(taller >= shorter + gap){
                return shorter + gap;
            } else {
                int top = shorter + gap;
                int down = taller + 1;
                return (top + down) / 2;
            }
        }


         // 3rd question
        public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
            // Write your code here
            List<Integer> result = new ArrayList<>();
            for(int i=0;i<a.size();i++){
                result.add(countDifference(a.get(i),b.get(i)));
            }

            return result;
        }
        public static int countDifference(String s1 , String s2){
            if(s1.length()!=s2.length()){
                return -1;
            }
            int count = 0;

            int charCount[] = new int[26];


            for (int i = 0; i < s1.length(); i++)
                charCount[s1.charAt(i) - 'a']++;

            for (int i = 0; i < s2.length(); i++)
                if (charCount[s2.charAt(i) - 'a']-- <= 0)
                    count++;

            return count;
        }


        // 4th question
        public static void finalPrice(List<Integer> prices) {
                long total = 0;
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < prices.size(); i++) {
                    while (!stack.isEmpty() &&  prices.get(stack.peek()) >= prices.get(i)) {
                        total += prices.get(stack.pop()) - prices.get(i);
                    }
                    stack.push(i);
                }
                List<Integer> result = new ArrayList<>();
                while (!stack.isEmpty()) {
                    int index = stack.pop();
                    total += prices.get(index);
                    result.add(0, index);
                }
                System.out.println(total);
                for (int i = 0; i <result.size() ; i++) {
                    System.out.print(result.get(i));
                }
        }
}
