package com.turnfly.algorithm.od;

import java.util.Scanner;

public class P4_2 {

    /**
     * 通过车辆最多的颜色
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(" ");
        int window = Integer.parseInt(in.nextLine());

        int l = 0, r = window - 1;
        int max = 0;
        while (r < line1.length && r - l + 1 == window) {
            int[] cache = new int[3];
            for (int i = l; i <= r; i++) {
                cache[Integer.valueOf(line1[i])]++;
            }
            l++;
            r++;
            int max_ = 0;
            for (int i : cache) {
                max_ = Math.max(max_, i);
            }
            max = Math.max(max, max_);
        }

        System.out.println(max);
    }



}
