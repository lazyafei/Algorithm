package com.turnfly.algorithm.od;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Final3 {
    /**
     * 给定坐标轴上一组线段，线段起点终点均为整数且长度不小于1，
     * 请找出所有的线段，这些线段可以覆盖住所有的线段
     *
     * Input：
     * 第一行输入为所有线段的数量，不超过10000
     * 后边每行表示一条线段，格式为x,y，x和y分别表示起点和终点，取值范围[-10^5, 10^5]
     *
     * Output:
     * 最少线段数量，为正整数；
3
1,4
2,5
3,6

ANS: 2
     * */

    public static void lowestSegmentCoverage() {
        Scanner s = new Scanner(System.in);
        int n = Integer.valueOf(s.nextLine());
        int[][] matrix = new int[n][2];
        int line = 0;
        while (s.hasNextLine()) {
            String[] arr = s.nextLine().split(",");
            matrix[line][0] = Integer.valueOf(arr[0]);
            matrix[line][1] = Integer.valueOf(arr[1]);
            line++;
            if (line == n) break;
        }

        Arrays.sort(matrix, Comparator.comparingInt(o -> o[1]));
        //res代表覆盖元素个数
        int res = 1;
        int init_right = matrix[0][1];
        //LC435重叠，还是有所区别
        for (int i = 1; i < n; i++) {
            if (init_right > matrix[i][0]) {
                //不重合
                //un_covered++;
                init_right = matrix[i][1];
            }
        }
        System.out.println(n);

    }

    public static void main(String[] args) {
        lowestSegmentCoverage();
    }

}
