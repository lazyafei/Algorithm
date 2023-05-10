package com.turnfly.algorithm.od;
import java.util.*;

public class P1_3 {

    /**
     * 最长广播响应
     * */
    static int m;
    static int n;
    static int[][] arr;
    static int max = 0;
    static boolean[] isVisited;
    static int dis[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] line1 = in.nextLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        arr = new int[m][2];
        isVisited = new boolean[m];
        dis = new int[m];
        int line = 0;
        while (in.hasNextInt()) {
            arr[line][0] = in.nextInt();
            arr[line][1] = in.nextInt();

            line++;
            if (line == m) break;
        }
        int start_node = in.nextInt();

        int farthest = bfs(start_node);
        System.out.println(farthest * 2);

    }

    public static int bfs(int start_node) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(start_node);
        isVisited[start_node] = true;
        //开始结点距离为0
        dis[start_node] = 0;

        while (!dq.isEmpty()) {
            int v = dq.remove();
            //找到v所有相邻结点
            ArrayList<Integer> nodeList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if(arr[i][0] == v) nodeList.add(arr[i][1]);
            }

            for (Integer i : nodeList) {
                if (!isVisited[i]) {
                    dq.add(i);
                    isVisited[i] = true;
                    dis[i] = dis[v] + 1;
                    max = Math.max(max, dis[i]);
                }
            }
        }
        return max;
    }






    private static int Dijkstra(int nn) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(nn);
        int count = 0;
        while (true) {
            ArrayList<Integer> integers1 = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (integers.contains(arr[i][0]) && !integers.contains(arr[i][1])) {
                    integers1.add(arr[i][1]);
                } else if (integers.contains(arr[i][1]) && !integers.contains(arr[i][0])){
                    integers1.add(arr[i][0]);
                }
            }
            integers.addAll(integers1);
            if(integers1.size() > 0) {
                count++;
            } else {
                break;
            }
        }
        return count * 2;
    }

}
