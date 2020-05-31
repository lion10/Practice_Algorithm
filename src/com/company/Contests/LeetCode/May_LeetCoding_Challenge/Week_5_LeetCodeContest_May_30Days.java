package com.company.Contests.LeetCode.May_LeetCoding_Challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Week_5_LeetCodeContest_May_30Days {

    public static void main(String[] args) {

    }

    // Day 29
   /** There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?*/

    static List<Integer>[] graph;
    static boolean[] visited, explored;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        graph = new List[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new LinkedList<>();

        for(int[] edge : prerequisites) graph[edge[0]].add(edge[1]);

        visited = new boolean[numCourses];
        explored = new boolean[numCourses];

        for(int course = 0; course < numCourses; course++)
            if(!visited[course] && isCyclic(course)) return false;

        return true;
    }

    private static boolean isCyclic(int course) {

        visited[course] = true;

        for(int newCourse : graph[course]) {
            if(!visited[newCourse] && isCyclic(newCourse)) return true;
            else if(!explored[newCourse]) return true;
        }

        explored[course] = true;
        return false;
    }

    // Day 30
    public static int[][] kClosest(int[][] points, int K) {

        int[] distance = new int[points.length];
        for(int i = 0; i < points.length; i++)
            distance[i] = calculateDistance(points[i]);

        Arrays.sort(distance);
        int kthDistance = distance[K - 1];
        int[][] kClosestPoints = new int[K][2];

        for(int i = 0, j = 0; i < points.length && j < K; i++)
            if(calculateDistance(points[i]) <= kthDistance)
                kClosestPoints[j++] = points[i];

        return kClosestPoints;

    }


    public static int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    // Day 31


}
