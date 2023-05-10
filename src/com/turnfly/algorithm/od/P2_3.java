package com.turnfly.algorithm.od;


import java.util.Arrays;
import java.util.Scanner;

public class P2_3 {

    /**
     * 任务混部
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer taskNum = Integer.parseInt(in.nextLine());
        int[][] task = new int[taskNum][3];
        int line = 0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            for (int i = 0; i < 3; i++) {
                task[line][i] = in.nextInt();
            }
            line++;
            if (line == taskNum) break;
        }

        //按结束时间排序
        Arrays.sort(task, (o1, o2) -> o1[1] - o2[1]);

        int res = task[0][2];
        //比较，时间不重合的取最大的服务器数量
        int init_right = task[0][1];
        for (int i = 1; i < taskNum; i++) {
            if (task[i][0] >= init_right) {
                res = Math.max(res, task[i][2]);
                init_right = task[i][1];
            } else {
                //时间冲突的直接加
                res += task[i][2];
            }
        }
        System.out.println(res);

    }




}
