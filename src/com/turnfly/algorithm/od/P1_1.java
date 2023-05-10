package com.turnfly.algorithm.od;


import java.util.*;

public class P1_1 {

    /**
     * 最长的顺子
     * */
    public static void main(String[] args) {
        String[] dict = new String[]{"3","4","5","6","7","8","9","10","J","Q","K","A"};
        HashMap<String, Integer> dict1 = new HashMap<String, Integer>(){{
            for (int i = 3; i <= 10; i++) put(String.valueOf(i), 4);
            put("J", 4);  put("Q", 4);  put("K", 4);  put("A", 4);
        }};

        Scanner in = new Scanner(System.in);
        String already_have = in.nextLine();
        String discard = in.nextLine();
        String all = already_have + "-" + discard;
        String[] allArr = all.split("-");
        for (String str : allArr) {
            if (dict1.containsKey(str)) dict1.put(str, dict1.get(str) - 1);
        }
        int l = 0;
        String res = "";
        for (int r = 0; r < dict.length; r++) {
            if (dict1.get(dict[r]) != 0) {
                if (r - l + 1 >= 5) {
                    String t = "";
                    for (int i = l; i <= r; i++) {
                        t += dict[i] + "-";
                    }
                    if (t.length() > 1) t = t.substring(0, t.length() - 1);
                    if (res.length() < t.length()) res = t;
                }
            } else {
                l = r + 1;
            }
        }

        System.out.println(res.equals("")?"NO-CHAIN":res);
    }




}
