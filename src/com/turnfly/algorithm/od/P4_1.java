package com.turnfly.algorithm.od;


import java.util.Scanner;

public class P4_1 {



    /**
     * MVP争夺战
     * */
    static int[] scores;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String[] line2 = in.nextLine().split(" ");
        scores = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.valueOf(line2[i]);
            sum += v;
            scores[i] = v;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (sum % i == 0) {
                int C = sum / i;
                //裸递归
                if (CIsValid(C)) {
                    boolean isExist = recursion(n - 1, C);
                    if(isExist){
                        min = Math.min(min, C);
                    }
                }
            }
        }


        System.out.println(min);
    }
    public static boolean CIsValid(int C) {
        for (int i : scores){
            if (C < i) return false;
        }
        return true;
    }

    public static boolean recursion(int index, int C) {
        if (C == 0) return true;
        if (index < 0 || C < 0) return false;
        return recursion(index - 1, C) || recursion(index - 1, C - scores[index]);
    }




}
