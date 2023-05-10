package com.turnfly.algorithm.od;


import java.util.*;

public class P1_2 {



    /**
     * 数据分类
     * */
    static int c,b;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(" ");
        HashMap<Integer, Integer> freq = new HashMap<>();
        c = Integer.valueOf(line1[0]);
        b = Integer.valueOf(line1[1]);
        for (int i = 2; i < line1.length; i ++) {
            //aList.add(Integer.valueOf(line1[2]));
            int aData = intByteSum(Integer.valueOf(line1[i])) % b;

            if (aData < c) {
                freq.put(aData, freq.getOrDefault(aData, 0) + 1);
            }
        }

        int max = 0;
        for (Integer i : freq.values()) {
            max = Math.max(max, i);
        }
        System.out.println(max);

    }

    public static int intByteSum(int x) {
        int sum = 0;
//        for (int i = 0; i < 4; i ++) {
//            sum += (x >> (i * 8)) & 0xff;
//        }
        int a = x >> 24;
        int b = (x - (a << 24)) >> 16;
        int c = (x - (a << 24) - (b << 16)) >> 8;
        int d = x - (a << 24) - (b << 16) - (c << 8);

        return a + b + c + d;
    }




}
