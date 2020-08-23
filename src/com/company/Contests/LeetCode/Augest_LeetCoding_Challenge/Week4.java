package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.Random;
import java.util.TreeMap;

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
    }
}
