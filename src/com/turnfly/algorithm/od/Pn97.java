package com.turnfly.algorithm.od;

import java.util.*;


/**
 * 任务调度2
 * */
public class Pn97 {

    static TreeMap<Integer, LinkedList<int[]>> pool;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextInt());
        // 0-3: 任务ID、任务优先级、执行时间、到达时间
        int[][] tasks = new int[n][4];
        int line = 0;
        while (in.hasNextLine()) {
            for (int i = 0; i < 4; i++) {
                tasks[line][i] = in.nextInt();
            }
            line++;
            if (line == n) break;
        }


        //考虑到任务优先级可能有重叠，使用LinkedList解决冲突
        pool = new TreeMap<>();
        int cur_time = 0;
        for (int[] task : tasks) {
            //任务池中先处理之前的任务
            executeJob(cur_time, task[3] - cur_time);
            //新任务到达
            pool.putIfAbsent(task[1], new LinkedList<>());
            pool.get(task[1]).add(task);
            //间隙时间的结束时间 更新为新任务的开始时间
            cur_time = task[3];
        }

        //任务添加完毕，剩下未执行的任务顺序执行
        Map.Entry<Integer, LinkedList<int[]>> entry;
        while(!pool.isEmpty()) {
            entry = pool.pollLastEntry();
            for (int[] task : entry.getValue()) {
                cur_time += task[2];
                resList.add(task[0] + " " + cur_time);
            }
        }

        for (String str : resList) {
            System.out.println(str);
        }
    }

    static LinkedList<String> resList = new LinkedList<>();
    public static void executeJob(int curTime, int idle_time){
        //不存在可执行时间、无等待任务
       if (idle_time <= 0) return;
       if (pool.isEmpty()) return;

       //获取优先级最高的任务列表
        LinkedList<int[]> list = pool.lastEntry().getValue();
        int[] task = list.get(0);
        //空闲时间不足以处理完任务，更新任务剩余执行时间
        if (task[2] > idle_time) {
            task[2] -= idle_time;
            return;
        }
        //任务执行完毕, 添加结果到resList
        resList.add(task[0] + " " + (curTime + task[2]));
        //先从队列移出，如果此时队列为空，则将pool结点移除；
        list.remove(task);
        if (list.isEmpty()) pool.remove(pool.lastEntry().getKey());
        //空闲时间剩余的多，继续执行下一次任务
        executeJob(curTime + task[2], idle_time - task[2]);
    }


}
