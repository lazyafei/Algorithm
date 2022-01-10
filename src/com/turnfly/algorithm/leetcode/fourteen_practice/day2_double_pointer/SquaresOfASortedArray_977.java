package com.turnfly.algorithm.leetcode.fourteen_practice.day2_double_pointer;


import com.turnfly.algorithm.CommonUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *  
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class SquaresOfASortedArray_977 {

    /**
     * 1、暴力法
     * */
    public static int[] sortedSquares(int[] nums) {
        int[] square_nums = new int[nums.length];
        int i = 0;
        for(int n : nums){
            square_nums[i++] = (int)Math.pow(n,2.0);
        }

        //不支持基本类型(int，double，char等)
        //Collections.reverseOrder()
        //Comparator.reverseOrder()
        Arrays.sort(square_nums);
        //, Comparator.naturalOrder()
        return square_nums;
    }



    /**
     * 2、双指针
     * */
    public static int[] sortedSquares2(int[] nums) {


        return null;
    }











    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        CommonUtil.showArray(sortedSquares(nums));
    }
}
