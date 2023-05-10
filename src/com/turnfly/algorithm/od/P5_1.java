package com.turnfly.algorithm.od;

import java.util.HashMap;
import java.util.Scanner;


/**
 * 找车位
 * */
public class P5_1 {

    static boolean[][] isVisited;
    static int[][] matrix;
    static HashMap<Integer, Integer> cacheMap;
    static int last_x = 0;
    static int last_y = 0;
    static int target_num;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(",");
        int n = line1.length;
        int l = 0, r = 0;
        int res = 0;
        while (r < n) {
            if (line1[r].equals("0")) {
                l = r;
                while (r + 1 < n && line1[r + 1].equals("0")) r++;
                res = Math.max(res, r - l + 1);
            }
            r++;
        }
        int max = res - res/2;
        System.out.println(max);

    }

}
