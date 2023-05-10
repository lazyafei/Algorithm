package com.turnfly.algorithm.od;

import java.util.Scanner;


/**
 * 数大雁
 * */
public class P5_2 {

    static String line;
    static boolean isUsed[];
    static int count = 0;
    static String word = "quack";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //n个图形
        line = in.nextLine();
        isUsed = new boolean[line.length()];
        for (int i = 0; i < line.length(); i++) {
            dfs(i,0);
        }
        if (count > 1) {
            System.out.println(count);
            return;
        }
        System.out.println(-1);
    }

    public static void dfs(int x, int key_index) {
        if (x >= line.length()) return;

        if (key_index == word.length()) {
            count++;
            return;
        }

        if (!isUsed[x]) {
            isUsed[x] = true;
            if (line.charAt(x) != word.charAt(key_index)) {
                dfs(x + 1,key_index);
            } else {
                dfs(x + 1,key_index + 1);
            }
        }

    }



}
