package com.turnfly.algorithm.od;


import java.util.Arrays;
import java.util.Scanner;

public class P6_1 {

    /**
     * 查找充电设备总和
     * */
    static int[][] memo;
    static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String[] arr_ = in.nextLine().split(" ");
        int target = Integer.valueOf(in.nextLine());

        int discard_num = 0;
        for (String str : arr_) {
            if (Integer.valueOf(str) > target) discard_num++;
        }
        if (discard_num == n) {
            System.out.println(0);
            return;
        }
        arr = new int[n - discard_num];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int v = Integer.valueOf(arr_[i]);
            if (v <= target) {
                arr[index++] = v;
            }
        }

        memo = new int[n][target + 1];

        if (dfs(n - 1, target)){
            System.out.println(target);
            return;
        } else {
            //排序从小到大相加，到小于target的临界值即可
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 0; i < arr.length ; i++) {
                sum += arr[i];
                if (sum > target) {
                    System.out.println(sum - arr[i]);
                    return;
                }
            }
        }
    }

    public static boolean dfs(int index, int C) {
        if (C == 0) return true;
        if (index < 0 || C < 0) return false;
        if (memo[index][C] != 0) return memo[index][C] == 2;
        memo[index][C] = dfs(index - 1, C) || dfs(index - 1, C - arr[index])
                ? 2 : 1;
        return memo[index][C] == 2;
    }

}
