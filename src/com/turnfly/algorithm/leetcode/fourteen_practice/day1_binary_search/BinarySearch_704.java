package com.turnfly.algorithm.leetcode.fourteen_practice.day1_binary_search;

/**
 * 704. Binary Search
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class BinarySearch_704 {

    public static int search(int[] nums, int target) {
        if(nums.length < 1) return -1;
        int l = 0, r = nums.length-1, m = 0;
        while(l <= r){
            m = l + (r-l)/2;
            if(target == nums[m])  return m;
            if(target > nums[m]){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return -1;
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
