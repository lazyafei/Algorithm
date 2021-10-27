package com.turnfly.algorithm.leetcode.fourteen_practice.day1_binary_search;

/**
 * 35. Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Example 4:
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 *
 * Example 5:
 * Input: nums = [1], target = 0
 * Output: 0
 *  
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 *
 *
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * */

public class SearchInsertPosition_35 {
    public static int search(int[] nums, int target) {
        if(nums.length < 1) return 0;
        int l = 0, r = nums.length-1, m = 0;
        while(l <= r){
            m = l + (r-l)/2;
            if(nums[m] == target) return m;
            if(nums[m] > target) r = m-1;
            if(nums[m] < target) l = m+1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int[] arr2 = {9};
        int[] arr3 = {};
        System.out.println(search(arr,12));
        System.out.println(search(arr,13));
        System.out.println(search(arr2,9));
        System.out.println(search(arr2,12));
        System.out.println(search(arr3,12));
    }


}
