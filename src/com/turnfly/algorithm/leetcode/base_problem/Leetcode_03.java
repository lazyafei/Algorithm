package com.turnfly.algorithm.leetcode.base_problem;

import java.util.*;

/**
 * @Author lazyafei
 * @Date 2022/1/11 9:23
 **/
public class Leetcode_03 {

    /**
     * List
     * */
    public static int lengthOfLongestSubstring0(String s){
         char[] arr = s.toCharArray();
         List<Character> subList = new ArrayList<>();
         int maxSubLength = 0;
         for(int i = 0; i < arr.length; i++){
             if(subList.contains(arr[i])){
                 subList = subList.subList(subList.indexOf(arr[i])+1,subList.size());
             }
             subList.add(arr[i]);
             maxSubLength = Math.max(maxSubLength,subList.size());
         }
         return maxSubLength;
    }


    /**
     * Set
     * */
    public static int lengthOfLongestSubstring1(String s) {
        if(s ==null || s.length()==0) return 0;
        int l=0,r=-1;
        int result = 0;
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        //注意边界条件
        while(l<s.length()){
            if(r+1<array.length && !set.contains(array[r+1])){
                set.add(array[++r]);
                result = Math.max(result,r-l+1);
            }else{
                //l++直到重复的值(以及重复值之前的数据 1(1x23)x11 -> 11x(23x)11 )刨除出去！
                set.remove(array[l++]);
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring11(String s){
        int r = 0, l = 0, res = 0;
        HashSet<Character> set = new HashSet<>();
        while(r<s.length()){
            char c = s.charAt(r++);
            while(set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res,set.size());
        }
        return res;
    }

    public static int lengthOfLongestSubstring111(String s) {
        if (s ==null || s.length() == 0) return 0;
        int result = 0;
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<> ();
        //右边添一个，左边可能动多个
        for (int l = 0, r = 0; r<array.length ; r++){
            while (set.contains(array[r])) {
                set.remove(array[l++]);
            }
            set.add(array[r]);
            //set.size()
            result = Math.max(result, r - l + 1);
        }
        return result;
    }


    /*
    * Queue
    * */
    public static int lengthOfLongestSubstring3(String s) {
        if(s ==null || s.length()==0) return 0;
        int result = 0;
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()){
            while (queue.contains(c)) {
                //此处while循环 - 如果有重复的，队头出队
                queue.poll();
            }
            queue.offer(c);
            result = Math.max(result,queue.size());
        }
        return result;
    }

    /*
    * Map
    * */
    public int lengthOfLongestSubstring4(String s) {
        int res = 0;
        Map<Character,Integer> map= new HashMap<>();
        for(int l = 0,r = 0;r < s.length(); ){
            if(map.containsKey(s.charAt(r))){
                //更新left索引下标
                l = Math.max(map.get(s.charAt(r)),l);
            }
            res = Math.max(res,r-l+1);
            //更新map最新值 (覆盖)
            map.put(s.charAt(r),++r);
        }
        return res;
    }



    /**
     * 字符范围有限，可以使用定长的数组代替map，来追求更高的性能。
     * 最巧妙的是if (map[c] >= left) 不仅替代了map.containsKey，也解决了 left 可能在前面出现过的问题
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);

        int res = 0, left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] >= left)
                left = map[s.charAt(i)] + 1;
            map[c] = i;
            res = Math.max(res, i - left);
        }

        return res + 1;
    }


    /*
         abcabcabc
      */
    public static int lengthOfLongestSubString(String s){
        if(s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int l = 0, r = -1;
        int res = 0;
        ArrayList<Character> subList = new ArrayList<>();
        while(l < s.length()){
            if(r+1<s.length()){
                if(subList.contains(arr[r+1])){
                    subList.remove(l++);
                    continue;
                }
                subList.add(arr[++r]);
                res = Math.max(res,subList.size());
            }
        }

        return res;
    }



}
