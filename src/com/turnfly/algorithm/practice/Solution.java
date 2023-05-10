package com.turnfly.algorithm.practice;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int maxLength = 1;
    int[] nums;
    int n;
    Map<Integer, Integer> cacheMap = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dfs(i));
        }
        return maxLength;
    }

    public int dfs(int index){
        if (cacheMap.get(index) != null) {
            return cacheMap.get(index);
        }

        int count = 1;
        for (int i = index + 1; i < n; i++) {
            if (nums[i] > nums[index]) {
                count = Math.max(count, dfs(i) + 1);
            }
        }
        cacheMap.put(index, count);

        return  cacheMap.get(index);
    }

    @Test
    public void main() {
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        //int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
