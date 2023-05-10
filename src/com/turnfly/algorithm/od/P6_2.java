package com.turnfly.algorithm.od;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P6_2 {

    /**
     * 任务总执行时常
     * */
    static int taskA;
    static int taskB;
    static int k;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(",");
        taskA = Integer.valueOf(line1[0]);
        taskB = Integer.valueOf(line1[1]);
        k = Integer.valueOf(line1[2]);
        ArrayList<Integer> resList = new ArrayList<>();
        for(int i = 0; i <= k; i++) {
            resList.add(i * taskA + (k - i) * taskB);
        }
        Collections.sort(resList);
        for (Integer i : resList) {
            System.out.print(i + ",");
        }
    }



}
