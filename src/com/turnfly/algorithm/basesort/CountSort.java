package com.turnfly.algorithm.basesort;


import com.turnfly.algorithm.utils.CommonUtil;

import java.util.Random;

/**
 * 计数排序
 * 适用于一定范围内的整数排序
 * */
public class CountSort {

    public static void countSort(int[] arr){
        System.out.print("20个数的随机数组为：");
        CommonUtil.showArray(arr);

        int[] cache = new int[11];
        for (int i : arr) {
            cache[i]++;
        }

        System.out.print("20个数的排序后数组为：");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < cache[i]; j++) {
                System.out.print(i+" ");
            }
        }
    }


    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(11);
        }
        countSort(arr);

    }
}
