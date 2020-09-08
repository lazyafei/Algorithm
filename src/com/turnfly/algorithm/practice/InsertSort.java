package com.turnfly.algorithm.practice;

import com.turnfly.algorithm.CommonUtil;

/**直接插入排序
 * 思路：将序列分成有序和无序两部分，每次从无序表中取出第一个元素，插入到有序表中合适的位置，使有序表仍然有序，直到无序表内所有元素插入为止；
 * 第一个元素默认看作有序，则开始无序区域有n-1个元素 => 需要n-1次循环操作；
 * 也可以看作斗地主起牌时，每拿起一张牌，需要从右至左找到对应位置！
 * */

public class InsertSort {
    public static void insertSort(int[] arr){
        CommonUtil.showArray(arr);
        //外层循环 - 无序区域有n-1个元素,n-1次循环
        for(int i=1; i<arr.length; i++){
            int cur = arr[i],j;  //取出无序区第一个元素的值，在有序区从右至左与其比较的过程中，这个位置会被覆盖；
            //内层循环 - 有序区间有j=i-1个元素，j次循环
            for(j=i-1; j>=0 && arr[j]>cur; j--){
                //遇到比无序区域第一个元素大的，把这个值往后移，腾出位置！
                arr[j+1] = arr[j]; //j+1最多也就是i不担心越界
            }
            //直到遇到比cur小的arr[j]，在其后插入
            arr[j+1] = cur;
        }
        CommonUtil.showArray(arr);
    }

    public static void main(String[] args) {
        insertSort(new int[]{9,8,7,6,5,4,3,2,1});
    }


}
