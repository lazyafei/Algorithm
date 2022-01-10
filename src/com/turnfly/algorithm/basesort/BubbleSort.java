package com.turnfly.algorithm.basesort;

import static com.turnfly.algorithm.CommonUtil.*;

public class BubbleSort {


    static void bubbleSort(int arr[]){
        boolean flag = true;
        for (int i = arr.length-1; i>=0 && flag; i--) {
            flag = false;
            //每次循环范围-1，共n-1 + n-2 + .... + 1 = (n-1)n/2 次
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
        }
        showArray(arr);
    }
}
