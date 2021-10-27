package com.turnfly.algorithm.leetcode.fourteen_practice.day1_binary_search;

/**
 * 278. First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */

public class FirstBadVersion_278 {
    static boolean isBadVersion(int m){
        if(m == 4 || m == 5 || m == 6){
            return true;
        }
        return false;
    }

    public static int firstBadVersion(int n) {
        int l = 1, r = n, m=0;
        //l==r时区间只有一个坏版本元素
        while(l < r){
            //防止int溢出
            m = l+(r-l)/2;
            if(isBadVersion(m)){
                //包含右区间
                r = m;
            }else{
                l = m+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(6));
    }
}
