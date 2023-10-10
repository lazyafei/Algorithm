package com.turnfly.algorithm.practice;

import java.util.*;

public class test {
    static int[][] intervals;
    static HashMap<Integer, Integer> cacheMaps = new HashMap<>();
    public static void main(String[] args) {
        intervals = new int[][]{{4, 5}, {2, 3}, {1, 2}};
        int m = intervals.length;
        int n = intervals[0].length;

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            // 获取区间所在下标（每个start不相同）
            cacheMaps.put(intervals[i][0], i);
        }

        int[][] startIntervals = new int[m][2];
        for (int i = 0; i < m; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = intervals[i][1];
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < m; i++) {
            res[i] = getIndex(startIntervals[i][1], 0, m - 1);
        }


        TreeMap<Long, HashMap<String, String>> cacheMaps = new TreeMap<>(Comparator.comparingLong(o -> o));
        Set<Long> s =   cacheMaps.keySet();
        new ArrayList<>(s);


    }


    public static int getIndex(int target, int l, int r) {
        while (l <= r) {
            int pivot = r - (r - l) / 2;
            if (intervals[pivot][0] < target) l = pivot + 1;
            if (intervals[pivot][0] > target) r = pivot - 1;
            if (intervals[pivot][0] == target) {
                return cacheMaps.get(target);
            }
        }
        return -1;
    }

}
