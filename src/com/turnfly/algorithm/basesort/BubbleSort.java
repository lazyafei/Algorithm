package com.turnfly.algorithm.basesort;

import static com.turnfly.algorithm.utils.CommonUtil.*;

public class BubbleSort {


    /**
     * 时间复杂度O(n^2)
     * */
    static void bubbleSort(int arr[]) {
        //arr[n - i, n)已经排好序，通过冒泡在arr[n - i - 1]位置上放上合适的元素
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        showArray(arr);
    }

    /**
     *
     * */
    static void bubbleSort2(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        showArray(arr);
    }


    /**
     * 增加Bollean判断，如果循环中发现一次交换都没有，则证明前面的元素已经是排好序的，直接返回即可
     * 对于传入有序数组的情况下，时间复杂度变为O(n)
     * */
    static void bubbleSort3(int arr[]) {
        boolean flag = true;
        for (int i = arr.length - 1; i >= 0 && flag; i--) {
            flag = false;
            //每次循环范围-1，共n-1 + n-2 + .... + 1 = (n-1)n/2 次
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
        }
        showArray(arr);
    }
}
