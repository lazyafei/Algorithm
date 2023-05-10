package com.turnfly.algorithm.od;

import java.util.HashMap;
import java.util.Scanner;


/**
 * 相同数字组成图形的周长
 * */
public class P5_3 {

    static boolean[][] isVisited;
    static int[][] matrix;
    static HashMap<Integer, Integer> cacheMap;
    static int last_x = 0;
    static int last_y = 0;
    static int target_num;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //n个图形
        int n = Integer.valueOf(in.nextLine());
        matrix = new int[64][64];
        isVisited = new boolean[64][64];
        cacheMap = new HashMap<>();
        int line = 0;
        while (in.hasNextLine()) {
            String[] a = in.nextLine().split(" ");
            target_num = Integer.parseInt(String.valueOf(a[0]));
            for (int i = 1; i < a.length; i = i + 2) {
                int x = Integer.parseInt(String.valueOf(a[i]));
                int y = Integer.parseInt(String.valueOf(a[i + 1]));
                matrix[x][y] = target_num;
            }
            int x = Integer.parseInt(String.valueOf(a[1]));
            int y = Integer.parseInt(String.valueOf(a[2]));
            last_x = Integer.parseInt(String.valueOf(a[a.length - 2]));
            last_y = Integer.parseInt(String.valueOf(a[a.length - 1]));
            dfs(x, y);

            line++;
            if(line == n) break;
        }

        for (Integer i : cacheMap.values()){
            System.out.print(i + " ");
        }
    }

    public static boolean dfs(int x, int y) {
        //外界看作非target
        if (x < 0 || y < 0 || x >= 64 || y >= 64) return true;
        if (matrix[x][y] != target_num) return true;

        if (!isVisited[x][y]) {
            isVisited[x][y] = true;
            //四个方向都是target，则为内部不算
            //四个方向，遇到边界或者非1元素，都可以当作周长的边
            int cn = 0;
            if (dfs(x - 1, y)) cn++;
            if (dfs(x, y + 1)) cn++;
            if (dfs(x + 1, y)) cn++;
            if (dfs(x, y - 1)) cn++;

            cacheMap.put(target_num, cacheMap.getOrDefault(target_num, 0) + cn);
        }
        return false;
    }

}
