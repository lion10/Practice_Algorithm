package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

public class Week_2_LeetCodeContest_May_30Days {

    public static void main(String[] args) {

        // Day 8
        System.out.println(checkStraightLine(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5},{7,7}}));
    }


    // Day 8
    /**
     *   Check If It Is a Straight Line
     *   You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate
     *   of a point. Check if these points make a straight line in the XY plane.*/
    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2)
            return true;

        int[] point1 = coordinates[1];
        int[] point2 = coordinates[0];
        float slopeFirstPoint = slope(point1, point2);

        for (int i = 2; i < coordinates.length; i++) {
            int[] p1 = coordinates[i];
            int[] p2 = coordinates[0];
            float slop = slope(p1, p2);
            if (slopeFirstPoint != slop)
                return false;
        }
        return true;
    }

    public static float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0)
            return 0;
        return (float) (p2[1] - p1[1]) / (p2[0] - p1[0]) ;
    }
}
