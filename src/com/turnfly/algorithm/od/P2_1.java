package com.turnfly.algorithm.od;


import java.util.*;

public class P2_1 {

    /**
     * 字符串重新排序
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(" ");

        for (String s : strings) System.out.print(s + " ");

        HashMap<String, Integer> maps = new HashMap<>();
        for (String str : strings) {
            maps.put(str, maps.getOrDefault(str, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
                //单词频率从大到小排
               if (o2.getValue() - o1.getValue() == 0) {
                   //长度从小到大排
                   if (o2.getKey().length() - o1.getKey().length() == 0 ) {

                       return o1.getKey().charAt(0) - o2.getKey().charAt(0);
                   }
                   return o1.getKey().length() - o2.getKey().length();
               }
               return o2.getValue() - o1.getValue();
        });
        pq.addAll(maps.entrySet());

        String[] res_str = new String[strings.length];
        int i = 0;
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            int freq = entry.getValue();
            String str = entry.getKey();
            //单词逆序
            char[] tc = str.toCharArray();
            Arrays.sort(tc);
            for (int j = 0; j < freq; j++) {
                res_str[i++] = String.valueOf(tc);
            }
        }

        System.out.println();
        for (String s : res_str) {
            System.out.print(s + " ");
        }
    }


}
