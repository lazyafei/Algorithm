package com.turnfly.algorithm.od;

import java.util.LinkedList;
import java.util.Scanner;


/**
 * 任务调度1
 * */
public class Pn96 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();
        while (in.hasNextInt()) {
            list.add(Integer.valueOf(in.nextInt()));
        }
        in.close();
        for (Integer i : list) {
            System.out.println(i);
        }

    }


}
