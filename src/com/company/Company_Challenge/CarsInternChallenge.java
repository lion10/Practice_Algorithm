package com.company.Company_Challenge;


import java.util.*;

public class CarsInternChallenge {
    public static void main(String[] args) {
        System.out.println("hi");
    }


    public static String newPassword(String a, String b) {
        String min = a.length() < b.length() ? a : b;
        String max = a.length() > b.length() ? a : b;

        StringBuffer temp = new StringBuffer("");
        for (int i = 0; i < min.length() ; i++) {
           temp.append(a.charAt(i)).append(b.charAt(i));
        }

        for (int i = min.length(); i < max.length() ; i++) {
            temp.append(max.charAt(i));
        }

        return String.valueOf(temp);
    }

    public static long carParkingRoof(List<Long> cars, int k) {

        if (cars.size() == 0 || k < 0) {
            return 0;
        }

       /* // i used it to now to max tow number => so i will walk during this path
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        long minPart = Long.MAX_VALUE;
        for (long car : cars) {
            maxHeap.offer(car);

            minPart = Math.min(minPart, car);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.poll() - minPart + 1;*/

        Collections.sort(cars);

        long minLength = Long.MAX_VALUE;

        for (int i = 0; i <= cars.size() - k; i++) {
            minLength = Math.min(minLength, cars.get(i + k - 1) - cars.get(i));
        }

        return minLength + 1;

    }


    public static int largestArea(List<List<Integer>> samples) {
        int rows = samples.size(), cols = samples.size();
        Integer[][] matrix = samples.stream()
                .map(l -> l.stream().toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        int[] dp = new int[cols + 1];
        int maxSequarelenght = 0, previous = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == 1) {
                    dp[j] = Math.min(Math.min(dp[j - 1], previous), dp[j]) + 1;
                    maxSequarelenght = Math.max(maxSequarelenght, dp[j]);
                } else {
                    dp[j] = 0;
                }
                previous = temp;
            }
        }
        return maxSequarelenght;
    }

}