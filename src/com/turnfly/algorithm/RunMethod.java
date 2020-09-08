package com.turnfly.algorithm;


import com.turnfly.algorithm.leetcode.Practice;

public class RunMethod {
    public static void main(String args[]){
        int arr[] = {4,-3,5,-2,-1,2,6,-2};
        System.out.println("最大子列和，分治法："+Practice.divideAndConquer(arr,0,arr.length-1));
        System.out.println("最大子列和，在线处理法："+Practice.maxSubList4(arr));

        int arr1[]= {1,2,3,4,5};
        int arr2[]= {4,5,3,2,1};
        Practice.IsPopOrder(arr1,arr2);
    }
}
