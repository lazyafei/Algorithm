package com.turnfly.algorithm.od;


import java.util.Scanner;

public class P3_2 {

    /**
     * 开心消消乐
     * */
    static int m,n;
    static int[][] memo;
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(" ");
        m = Integer.valueOf(line1[0]);
        n = Integer.valueOf(line1[1]);

        matrix = new int[m][n];
        int line = 0;
        while (in.hasNextInt()) {
            for (int i = 0; i < n; i++) {
                matrix[line][i] = in.nextInt();
            }
            line++;
            if (line == m) break;
        }
        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    res++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(res);

    }

    public static void dfs(int x, int y){
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (matrix[x][y] == 0) return ;
        if (memo[x][y] != 0) return;

        matrix[x][y] = 0;
        memo[x][y] = 1;
        dfs(x - 1, y - 1);
        dfs(x - 1, y + 1);
        dfs(x + 1, y + 1);
        dfs(x + 1, y - 1);
        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x , y + 1);
    }




}
