package com.turnfly.algorithm.od;

import java.util.*;

public class P6_3 {

    /**
     * 士兵过河2
     * */
    static HashMap<Integer, Integer> resList;
    static int limit_time;
    static int[] times;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        limit_time = Integer.valueOf(in.nextLine());
        String[] person_times = in.nextLine().split(" ");
        times = new int[n];
        for (int i = 0; i < n ; i ++) {
            times[i] = Integer.valueOf(person_times[i]);
        }
        Arrays.sort(times);
        if (times[0] > limit_time) {
            System.out.println("0 0");
            return;
        }
        if (n < 2) {
            System.out.println("1 " + times[0]);
            return;
        }

        int[] dp = new int[n];
        dp[0] = times[0];
        dp[1] = Math.min(times[0] * 10, times[1]);
        if (dp[1] > limit_time) {
            System.out.println("1 " + dp[0]);
            return;
        }

        for (int i = 2; i < n; i++) {
            int a1 = dp[i - 1] + times[0] + Math.min(times[0] * 10, times[i]);
            int a2 = dp[i - 2] + times[0] + Math.min(times[i - 1] * 10, times[i]) + times[1] + dp[1];
            dp[i] = Math.min(a1, a2);
            if(dp[i] > limit_time) {
                System.out.println(i + " " + dp[i - 1]);
                return;
            };
        }
        System.out.println(n + " " + dp[n - 1]);
    }

}
