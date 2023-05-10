package com.turnfly.algorithm.od;

import java.util.Scanner;

public class P3_3 {

    /**
     * 机房布局
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (!str.contains("I")) {
            System.out.println("-1");
            return;
        }
        if (!str.contains("M")) {
            System.out.println("0");
            return;
        }
        int l = 0, r = 0;
        int res = 0;
        while (r < str.length()) {

            while (String.valueOf(str.charAt(r)).equals("I") && r+1 < str.length())  r++;
            res++;
            if (String.valueOf(str.charAt(l)).equals("M")) {
                res++;
            }
            if (r + 1 < str.length()) {
                if (String.valueOf(str.charAt(r + 1)).equals("M")) {
                    res++;
                }
            }
        }


    }
}
