package com.turnfly.algorithm.od;

import java.util.Arrays;
import java.util.Scanner;

public class P2_2 {

    /**
     * 租车骑绿道
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(" ");
        int m = Integer.valueOf(line1[0]);
        int n = Integer.valueOf(line1[1]);
        String[] line2 = in.nextLine().split(" ");
        int weights[] = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.valueOf(line2[i]);
        }

        Arrays.sort(weights);
        int l = 0, r = n - 1;
        int count = 0;
        while (l <= r) {
            if (weights[l] + weights[r] <= m) {
                l++;
            }
            count++;
            r--;
        }
        System.out.println(count);
    }
}
