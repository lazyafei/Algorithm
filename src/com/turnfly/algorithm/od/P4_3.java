package com.turnfly.algorithm.od;


import java.util.LinkedList;
import java.util.Scanner;

public class P4_3 {

    /**
     * 分奖金
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String[] line1 = in.nextLine().split(" ");
        int arr[] = new int[n];
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(line1[i]);
        }
        //int[] dp = new int[n];

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    arr[j] = Math.max(arr[j], (i - j) * (arr[i] - Integer.valueOf(line1[j])));
                }
            }
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }


    }



}
